package com.company;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public class foe extends AnimatedThing{

    //Définition des attributs de la classe
    private double positionX;
    private double positionY;
    private Integer attitude;
    private String fileName;
    private ImageView imageFoe;

    //Définition du constructeur
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

    //Définition de la méthode qui met à jour l'image de l'ennemi
    public void miseAJourFoe(double ImageFoe){
        this.imageFoe.setViewport(new Rectangle2D(ImageFoe*88, 0, 88, 109));
    }

    //Fonctions get et set
    public double getPositionX() {return positionX;}
    public double getPositionY() {return positionY;}
    public void setPositionX(double positionX) {this.positionX = positionX;}

}
