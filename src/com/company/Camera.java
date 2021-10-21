package com.company;

public class Camera {
    private Integer x=0;
    private Integer y=0;

    public Integer getX() {return x;}
    public Integer getY() {return y;}


    public Camera(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}
