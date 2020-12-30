package com.example.myPackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.omg.PortableInterceptor.LOCATION_FORWARD;

public class Main {

    public static void main(String[] args) {
        final BankAccount bankAccount = new BankAccount("12345-678", 1000.00);

        new Thread(() -> {
            bankAccount.deposit(300.00);
            bankAccount.withdraw(50.00);
        }).start();

        new Thread(() -> {
            bankAccount.deposit(203.75);
            bankAccount.withdraw(100.00);
        }).start();
    }
}

class BankAccount {
    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccount(final String accountNumber, final double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.lock = new ReentrantLock();
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void setBalance(final double balance) {
        this.balance = balance;
    }

    public void deposit(final double amount) {
        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    setBalance(getBalance() + amount);
                    status = true;
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Am dat de naspa la deposit");
        }
        System.out.println("Transaction deposit status = " + status);
    }

    public void withdraw(final double amount) {
        boolean status = false;
        lock.tryLock();
        try {
            if ((lock.tryLock(1000, TimeUnit.MILLISECONDS)) && (getBalance() - amount) >= 0) {
                try {
                    setBalance(getBalance() - amount);
                    status = true;
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Am dat de naspa la withdraw");
        }
        System.out.println("Transaction withdraw status = " + status);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number = " + accountNumber);
    }
}

//class AccountOwner{
//    private BankAccount bankAccount;
//    private String name;
//
//    public AccountOwner(final BankAccount bankAccount, final String name) {
//        this.bankAccount = bankAccount;
//        this.name = name;
//    }
//
//    public synchronized void deposit(final double amount){
//        this.bankAccount.setBalance(this.bankAccount.getBalance() + amount);
//        System.out.println(this.name + " deposit " + amount + " and the new balance is " + this.bankAccount
//        .getBalance());
//    }
//
//    public synchronized void withdraw(final double amount){
//        if ((this.bankAccount.getBalance() - amount) >= 0){
//            this.bankAccount.setBalance((this.bankAccount.getBalance() - amount));
//            System.out.println(this.name + " withdraws " + amount + " and the new balance is " + this.bankAccount
//            .getBalance());
//        }
//    }
//
//
//}
