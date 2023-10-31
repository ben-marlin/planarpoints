package edu.guilford;

// author: ben marlin
// class for simple points in the plane

import java.util.Random;
import java.lang.Math;

public class Point {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        Random rand = new Random();

        this.x = rand.nextDouble() * 10.0 - 5.0;    // sets in (-5,5)
        this.y = rand.nextDouble() * 10.0 - 5.0;
    }
    
    public String toString() {
        String s = "(" + String.format("%.3f",x) + "," + String.format("%.3f",y) + ")";

        return s;
    }

    public void translate(double dx, double dy) {    // moves point 
        this.x += dx;
        this.y += dy;
    }

    public void conjugate() {           // flips about x-axis
        this.y = - y;
    }

    public double norm() {
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    public double arg() {
        double theta = 0;               // default value if x = y = 0
        double r = this.norm();

        if (r > 0) {                    // only if x, y both nonzero
            theta = Math.asin(y / r);
        }

        if (x < 0) {                    // only in left half plane
            double s = x / Math.abs(x);
            theta += s * Math.PI;       // makes range [-pi,pi]
        }

        return theta;
    }
}
