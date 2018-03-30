package com.revature.demos.deadlock;

import java.util.Date;

public class Philosopher implements Runnable{
    private Object leftFork;
    private Object rightFork;

    public Philosopher(Object leftFork, Object rightFork){
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void doAction(String action) throws InterruptedException{
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep((int)Math.random()*100);
    }

    private String currentTime(){
        return new Date(System.currentTimeMillis()).toString();
    }

    @Override
    public void run(){
        try{
            while(true){
                doAction(currentTime() + ": Thinking");
                synchronized (rightFork){
                    doAction(currentTime() + ": picked up the right fork");
                    synchronized (leftFork){
                        doAction(currentTime() + ": Picked up the left fork, now eating");
                        doAction(currentTime() + ": set down the left fork");

                    }
                    doAction(currentTime() + ": set down the right fork,");
                }
            }
        } catch (InterruptedException e){
            e.printStackTrace();
            return;
        }
    }
}
