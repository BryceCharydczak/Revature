package com.revature.demos.oopfun.models;

public class Beta {

    public int myPublitInt =1;
    protected double myProtectedDouble = 5.0;
    private char myPrivateChar = 'a';
    String myPackageString = "hello";

    public static int myPublicStaticInt = 2;
    protected static double myProtectedStaticDouble = 10.0;
    private static char myPrivateStaticChar = 'b';
    static String myPackageStaticSTring = "hola";

    public final int MY_PUBLIC_FINAL_INT = 100;
    protected final double MY_PROTECTED_FINAL_DOUBLE = 2.16;
    private final char MY_PRIVATE_FINAL_CHAR = 'z';
    final String MY_PACKAGE_FINAL_STRING = "boolean";


    public int publicIntGetter(){
        return myPublitInt;
    }
}
