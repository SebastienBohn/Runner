package com.company;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.util.ArrayList;

public class AnimatedThing {

    private double positionX;
    private double positionY;
    private ImageView imageDynamique;
    private String filename;
    private Integer attitude;
    //Pour l'animation :
    private Integer dureeFrame;
    private ArrayList<Integer> Index = null;
    private double rectangleX;
    private double rectangleY;
    private double longueur;
    private double hauteur;




    public AnimatedThing(double positionX, double positionY, Integer attitude, String fileName){
        this.positionX = positionX;
        this.positionY = positionY;
        this.attitude = attitude;
        this.filename = fileName;
        this.imageDynamique = new ImageView(new Image(this.filename));

        switch (attitude){
            case 0 :
                this.rectangleX = 20;
                this.rectangleY = 0;
                this.longueur = 65;
                this.hauteur = 100;
                break;
            case 1 :
                this.rectangleX = 21;
                this.rectangleY = 160;
                this.longueur = 60;
                this.hauteur = 105;
                break;
            case 2 :
                this.rectangleX = 0;
                this.rectangleY = 325;
                this.longueur = 65;
                this.hauteur = 100;
                break;
            case 3 :
                this.rectangleX = 0;
                this.rectangleY = 490;
                this.longueur = 65;
                this.hauteur = 100;
                break;
            default:
                this.rectangleX = 0;
                this.rectangleY = 1;
                this.longueur = 65;
                this.hauteur = 100;
                break;
        }

        this.imageDynamique.setViewport(new Rectangle2D(this.rectangleX, this.rectangleY, this.longueur, this.hauteur));
        this.imageDynamique.setX(this.positionX);
        this.imageDynamique.setY(this.positionY);
    }


    public ImageView getImageDynamique() {return this.imageDynamique;}




}
