package com.company;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class staticThing {

    private double longueur;
    private double largeur;
    ImageView background;

    public staticThing(double longueur, double largeur, String fileName){
        this.longueur = longueur;
        this.largeur = largeur;
        this.background = new ImageView(new Image(fileName));
    }

    public ImageView getBackground() {return background;}

}
