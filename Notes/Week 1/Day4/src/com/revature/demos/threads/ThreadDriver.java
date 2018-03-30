package com.revature.demos.threads;

public class ThreadDriver {
    public static void main(String[] args){

        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        emp1.start();
        emp2.start();

        System.out.println(emp1.getPriority());
        System.out.println(emp2.getPriority());
    }
}
