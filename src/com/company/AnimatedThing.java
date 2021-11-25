package com.company;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.util.ArrayList;

public class AnimatedThing {

    //Définition des attributs de la classe
    private double positionX;
    private double positionY;
    private ImageView imageDynamique;
    private String filename;
    //Pour l'animation :
    private ArrayList<Integer> IndexPosX = null;
    private double rectangleX = 0;
    private double rectangleY = 0;

    //Définition du constructeur
    public AnimatedThing(double positionX, double positionY, Integer attitude, String fileName){
        this.positionX = positionX;
        this.positionY = positionY;
        this.filename = fileName;
        this.imageDynamique = new ImageView(new Image(this.filename));
    }

    //Définition de la méthode qui regarde s'il y a collision entre le heros et l'ennemi
    public Integer Rectangle2DgetHitBox(double positionHerosX, double positionHerosY, double longueurHeros, double hauteurHeros, double positionFoeX, double positionFoeY){
        //On regarde si le personnage est verticalement ET horizontalement en train de toucher l'ennemi
        if(positionFoeX>=100 && positionFoeX<=(100+longueurHeros)){
            if((positionHerosY+hauteurHeros)>=positionFoeY){
                return 1;
            }
        }
        return 0;
    }

    //Fonctions get et set
    public ImageView getImageDynamique() {return this.imageDynamique;}
}
