package com.revature.demos.oopfun.models;

public class Charlie extends Beta {


    //Variable Shadowing
    //Since charlie extends Beta, it inherits all of Betas public and protected members
    //since two instance variables have the same name, charlie's variable shadows Beta's
    public int myPublicInt = 9;

    @Override
    public int publicIntGetter(){
        return myPublicInt;
    }

}
