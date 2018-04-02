package com.revature.designpatterns.demos.behavioral.observer;

public class OctalObserver extends Observer {


    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.add(this);
    }
    @Override
    public void update(){
        System.out.println(subject.getState() + " as hex " + Integer.toOctalString(subject.getState()));
    }
}
