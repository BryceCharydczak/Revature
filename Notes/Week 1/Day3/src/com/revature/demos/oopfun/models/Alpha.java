package com.revature.demos.oopfun.models;

public class Alpha {

    public static void main(String[] args) {

        Charlie obj1 = new Charlie();
        System.out.println(obj1.myPublicInt);

        Beta obj2 = new Charlie();
        System.out.println(obj2.myPublitInt);

        System.out.println(obj1.publicIntGetter());
    }
}
