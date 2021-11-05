package com.company;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class foe extends AnimatedThing{

    private double positionX;
    private double positionY;
    private Integer attitude;
    private String fileName;
    private ImageView imageFoe;



    public foe(double positionX, double positionY, Integer attitude, String fileName){
        super(positionX,positionY,attitude, fileName);
        this.positionX = positionX;
        this.positionY = positionY;
        this.attitude = attitude;
        this.fileName = fileName;
        this.imageFoe = getImageDynamique();
        this.imageFoe.setX(this.positionX);
        this.imageFoe.setY(this.positionY);
    }

    public double getPositionX() {return positionX;}
    public double getPositionY() {return positionY;}


}
