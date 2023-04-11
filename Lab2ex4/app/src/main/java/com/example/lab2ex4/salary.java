package com.example.lab2ex4;

public class salary {
    private String username;
    private int salary;
    private double tax;
    private double netSalary;
    private double a;
    public salary(String username, int salary) {
        this.username = username;
        this.salary = salary;
    }
    public void calculateSalary() {
        a =  salary - (salary * 0.105);
        if (a < 11000000) {
            netSalary = a;
        } else {
            tax = (a - 11000000) * 5 / 100;
            netSalary = a - tax;
        }
    }

    public String getUsername() {
        return username;
    }
    public double getNetSalary() {
        return netSalary;
    }
}