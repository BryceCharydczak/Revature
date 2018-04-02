package com.revature.designpatterns.demos.behavioral.observer;

import java.util.Scanner;

public class ObserverDriver {
    public static void main(String[] args){


        Subject subject = new Subject();
        new HexObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);


        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("please enter a number: ");
            try {
                subject.setState(scan.nextInt());
            } catch (Exception e) {
                e.printStackTrace();
                main(args);
            }
        }

        scan.close();

    }
}
