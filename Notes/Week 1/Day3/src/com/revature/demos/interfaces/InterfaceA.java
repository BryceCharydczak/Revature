package com.revature.demos.interfaces;

public interface InterfaceA {
    void doSomething();

    default void doSomethingElse(){
        System.out.println("InterfaceA is doing something.");
    }
}
