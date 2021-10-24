package com.company;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;

public class staticThing {

    private double positionX;
    private double positionY;
    private double longueur;
    private double hauteur;
    private String filename;
    private ImageView background;

    public staticThing(double X, double Y, double longueur, double hauteur, String fileName){
        this.positionX = X;
        this.positionY = Y;
        this.longueur = longueur;
        this.hauteur = hauteur;
        this.filename = fileName;
        this.background = new ImageView(new Image(this.filename));
        DispositionBackground();
    }


    public void DispositionBackground() { //Pour découper et mettre l'image au bon endroit sur la scene
        this.background.setViewport(new Rectangle2D(this.positionX, this.positionY, this.longueur, this.hauteur));
        this.background.setX(this.positionX);
    }


    public ImageView getBackground() {return background;}
    public double getPositionX() {return positionX;}
    public double getPositionY() {return positionY;}
    public String getFilename() {return filename;}

}
