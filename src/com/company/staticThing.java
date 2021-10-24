package com.company;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class staticThing {

    private double positionX;
    private double positionY;
    // private double longueur;
    // private double hauteur;
    private String filename;
    private ImageView background;

    public staticThing(double X, double Y, double longueur, double hauteur, String fileName){
        this.positionX = X;
        this.positionY = Y;
        // this.longueur = longueur;
        // this.hauteur = hauteur;
        this.filename = fileName;
        this.background = new ImageView(new Image(fileName));
    }

    public ImageView getBackground() {return background;}
    public double getPositionX() {return positionX;}
    public double getPositionY() {return positionY;}
    public String getFilename() {return filename;}

}
