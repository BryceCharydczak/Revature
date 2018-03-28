package com.revature.demos;

import com.revature.demos.oopfun.models.Student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {
    public static void main(String[] args){
        Student stu = new Student(321654, "Brent", "Patty", "123456", 25);
        try{
            FileOutputStream fos = new FileOutputStream("Student.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(stu);
            oos.close();
            fos.close();
            System.out.println("finish");
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
