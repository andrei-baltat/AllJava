package com.example.myPackage;

public class BankAccount {

    private String firstName;
    private String lastName;
    private double balance;

    public BankAccount(final String firstName, final String lastName, final double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public double deposit( double amount, boolean branch){
        balance += amount;
        return balance;
    }

    public double withdraw(double amount, boolean branch){
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    // more methids tat use firstname, last name and perform other functions
}
