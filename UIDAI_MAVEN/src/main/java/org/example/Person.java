package org.example;
import java.util.*;
public class Person {
    private String name;
    private int age;
    private double balance;
    private List<String> interest;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getInterest() {
        return interest;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

