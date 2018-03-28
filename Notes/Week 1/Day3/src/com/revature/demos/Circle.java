package com.revature.demos;

import static java.lang.Math.*;

public class Circle {
    private double circumference;
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getCircumference() {
        return circumference;
    }

    public void setCircumference(double circumference) {
        this.circumference = circumference;
    }

    public void calculateCircumference(double radiusVal){
        this.radius = radiusVal;
        this.circumference = 2 * PI * this.radius;
    }
}
