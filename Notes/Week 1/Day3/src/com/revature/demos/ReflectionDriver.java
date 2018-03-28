package com.revature.demos;
import java.lang.reflect.Field;

public class ReflectionDriver {
    public static void main(String[] args){

        String s = "Strings are always imutable, right?";

        Class<String> stringClass = String.class;
        System.out.println("Initial Value: " + s);

        try{
            //Get access to the 'value' member of the String class
            Field value = stringClass.getDeclaredField("value");

            // change the accessibility of our 'value' attribute to true
            // a value of true means the reflected object should suppress
            // java language access checking when it is used.
            value.setAccessible(true);

            // change 'value' to be something else
            value.set(s, "mutated".toCharArray());
            System.out.println("New value: " + s);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(s);
        System.out.println("Strings are always imutable, right?");


        //what happens if we dereference our initial String object, so it can be garbage collected?
        s=null;
        System.gc();

        while("Strings are always imutable, right?".equals("mutated")){
            System.out.println("Strings are always imutable, right?");
        }


    }
}
