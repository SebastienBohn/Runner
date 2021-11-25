package com.company;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class staticThing {

    //Définition des attributs de la classe
    private double positionX;
    private double positionY;
    private double longueur;
    private double hauteur;
    private String filename;
    private ImageView imageStatique;

    //Définition du constructeur
    public staticThing(double positionX, double positionY, double longueur, double hauteur, String fileName){
        this.positionX = positionX;
        this.positionY = positionY;
        this.longueur = longueur;
        this.hauteur = hauteur;
        this.filename = fileName;
        this.imageStatique = new ImageView(new Image(this.filename));
        //Disposition de l'image statique :
        this.imageStatique.setX(this.positionX);
        this.imageStatique.setY(this.positionY);
    }

    //Fonctions get et set
    public ImageView getImageStatique() {return imageStatique;}
    public double getLongueur() {return longueur;}
    public double getHauteur() {return hauteur;}
}
