package com.revature.demos;

public class ScopeDriver {
    private static int myOuterInt = 9;

    // myInnerInt is not visible to us. So we cannot access it
    public int getMyInnerInt(){
        //return myInnerInt;
        return 0;
    }

    class SomeClass{
        //private int myInnerInt = 6;
        //protected int myInnerInt = 4;
        public int myInnerInt = 5;

        public int getMyOuterInt(){
            return myOuterInt;
        }
    }
}
