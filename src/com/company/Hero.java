package com.company;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hero extends AnimatedThing {

    private double positionX;
    private double positionY;
    private Integer attitude;
    private String fileName;
    private ImageView imageDynamique;
    private double rectangleX;
    private double rectangleY;

    public Hero(double positionX, double positionY, Integer attitude, String fileName){
        super(positionX,positionY,attitude, fileName);
        this.positionX = positionX;
        this.positionY = positionY;
        this.attitude = attitude;
        this.fileName = fileName;

        this.imageDynamique = getImageDynamique();
        this.imageDynamique.setViewport(new Rectangle2D(0, 5, 75, 100));
        this.imageDynamique.setX(this.positionX);
        this.imageDynamique.setY(this.positionY);
    }

    public void Update (long time) {
        //Le héros avance
        positionX = (positionX + 3);
    }

    public double getPositionX() {return positionX;}
    public double getPositionY() {return positionY;}


}
