package com.company;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;

public class staticThing {

    private double positionX;
    private double positionY;
    private double rectangleX;
    private double rectangleY;
    private double longueur;
    private double hauteur;
    private String filename;
    private ImageView background;

    public staticThing(double positionX, double positionY, double rectangleX, double rectangleY, double longueur, double hauteur, String fileName){
        this.positionX = positionX;
        this.positionY = positionY;
        this.rectangleX = rectangleX;
        this.rectangleY = rectangleY;
        this.longueur = longueur;
        this.hauteur = hauteur;
        this.filename = fileName;
        this.background = new ImageView(new Image(this.filename));
        DispositionBackground();
    }


    public void DispositionBackground() { //Pour découper et mettre l'image au bon endroit sur la scene
        this.background.setViewport(new Rectangle2D(this.rectangleX, this.rectangleY, this.longueur, this.hauteur));
        this.background.setX(this.positionX);
        this.background.setY(this.positionY);
    }


    public ImageView getBackground() {return background;}
    public double getPositionX() {return positionX;}
    public double getPositionY() {return positionY;}
    public String getFilename() {return filename;}

}
