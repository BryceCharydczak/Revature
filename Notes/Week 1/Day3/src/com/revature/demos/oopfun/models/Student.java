package com.revature.demos.oopfun.models;

import java.io.Serializable;

public class Student implements Serializable {

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDemDigits() {
        return demDigits;
    }

    public void setDemDigits(String demDigits) {
        this.demDigits = demDigits;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    private int studentID;
    private String firstName;
    private String lastName;
    private String demDigits;
    private int studentAge;

    private static final long serialVersionUID = 1L;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (studentID != student.studentID) return false;
        if (studentAge != student.studentAge) return false;
        if (!firstName.equals(student.firstName)) return false;
        if (!lastName.equals(student.lastName)) return false;
        return demDigits.equals(student.demDigits);
    }

    @Override
    public int hashCode() {
        int result = studentID;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + demDigits.hashCode();
        result = 31 * result + studentAge;
        return result;
    }

    public Student(int studentID, String firstName, String lastName, String demDigits, int studentAge) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.demDigits = demDigits;
        this.studentAge = studentAge;

    }


}
