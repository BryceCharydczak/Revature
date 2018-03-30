package com.revature.demos.threads;

public class Employee extends Thread {
    @Override
    public void run(){



        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " is working " + i);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }

        }
    }
}
