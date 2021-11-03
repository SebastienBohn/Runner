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
    private ImageView imageStatique;

    public staticThing(double positionX, double positionY, double longueur, double hauteur, String fileName){
        this.positionX = positionX;
        this.positionY = positionY;
        this.longueur = longueur;
        this.hauteur = hauteur;
        this.filename = fileName;
        this.imageStatique = new ImageView(new Image(this.filename));
        this.imageStatique.setX(this.positionX);
        this.imageStatique.setY(this.positionY);
        //Disposition de l'image statique :
        this.imageStatique.setX(this.positionX);
        this.imageStatique.setY(this.positionY);
    }


    public ImageView getImageStatique() {return imageStatique;}

    public double getLongueur() {return longueur;}
    public double getHauteur() {return hauteur;}
    public double getPositionX() {return positionX;}
    public double getPositionY() {return positionY;}
    public String getFilename() {return filename;}

}
