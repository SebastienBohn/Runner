package com.company;

public class Camera {
    private double x=0;
    private double y=0;

    public Camera(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public void Update(long time, double posXheros){
        //double acceleration = (posXheros-this.x)+1.2*vitesse;
        //double vitesse = acceleration*time;
        //this.x = vitesse*time;
        this.x = posXheros;
    }


    @Override
    public String toString() {
        return x + "," + y;
    }

    public double getX() {return x;}
    public double getY() {return y;}
}
