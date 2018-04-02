package com.revature.designpatterns.demos.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();

    private int state;
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        execute();
    }

    public void add(Observer o){
        observers.add(o);
    }

    private void execute(){
        for(Observer o: observers){
            o.update();
        }
    }

}
