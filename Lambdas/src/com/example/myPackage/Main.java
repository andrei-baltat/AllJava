package com.example.myPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
                Employee john = new Employee("John Doe", 30);
                Employee tim = new Employee("Tim buch", 21);
                Employee jack = new Employee("Jack Hill", 40);
                Employee snow = new Employee("Snow White", 21);

                List<Employee> employees = new ArrayList<>();
                employees.add(john);
                employees.add(tim);
                employees.add(jack);
                employees.add(snow);

                employees.forEach(employee -> {
                    System.out.println(employee.getName());
                    System.out.println(employee.getAge());
                });
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {

    public String doSomething() {
        int i = 0;
        UpperConcat uc = (s1, s2) -> {
            System.out.println("the lambda expression's class is " + getClass().getSimpleName());
            System.out.println("i in the lambda expression = " + i);
            return s1.toUpperCase() + s2.toUpperCase();
        };
        System.out.println("The Another class name is " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String 1", "String 2");

    }

    public void printValue(){
        int number = 25;
        Runnable r = () -> {
          try {
              Thread.sleep(5000);
          } catch (InterruptedException e){
              e.printStackTrace();
          }
            System.out.println("the value is " + number);
        };

        new Thread(r).start();
    }
}