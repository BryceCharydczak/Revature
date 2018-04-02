package com.revature.designpatterns.demos.behavioral.observer;

public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.add(this);
    }
    @Override
    public void update(){
        System.out.println(subject.getState() + " as hex " + Integer.toBinaryString(subject.getState()));
    }
}
