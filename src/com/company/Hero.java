package com.company;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hero extends AnimatedThing {

    private double positionX;
    private double positionY;
    private Integer attitude;
    private String fileName;
    private ImageView imageHeros;
    private double rectangleX;
    private double rectangleY;

    public Hero(double positionX, double positionY, Integer attitude, String fileName){
        super(positionX,positionY,attitude, fileName);
        this.positionX = positionX;
        this.positionY = positionY;
        this.attitude = attitude;
        this.fileName = fileName;
        this.imageHeros = getImageDynamique();
        this.imageHeros.setX(this.positionX);
        this.imageHeros.setY(this.positionY);
    }

    public void miseAJourHeros(long time, double ImageHeros){
        //Maj de l'attitude du heros :


        //Maj de l'image du heros :
        this.imageHeros.setViewport(new Rectangle2D(ImageHeros*85, 0, 85, 100));

    }




    public void Update (long time) {
        //Le héros avance
        positionX = (positionX + 5);
    }

    public double getPositionX() {return positionX;}
    public double getPositionY() {return positionY;}
    public Integer getAttitude() {return attitude;}


}
