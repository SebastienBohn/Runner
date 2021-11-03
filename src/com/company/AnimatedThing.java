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
    //private Integer attitude;
    //Pour l'animation :
    private Integer dureeFrame;
    private ArrayList<Integer> IndexPosX = null;
    private double rectangleX = 0;
    private double rectangleY = 0;
    private double longueur;
    private double hauteur;

    public AnimatedThing(double positionX, double positionY, Integer attitude, String fileName){
        this.positionX = positionX;
        this.positionY = positionY;
        //this.attitude = attitude;
        this.filename = fileName;
       // this.IndexPosX = new ArrayList<Integer>();
       // for(int i=0;i<5;i++){
        //    this.IndexPosX.add(10+i*75);
       // }

        this.imageDynamique = new ImageView(new Image(this.filename));
        //this.imageDynamique.setViewport(new Rectangle2D(this.rectangleX, this.rectangleY, 75, 100));
        //this.imageDynamique.setX(this.positionX);
        //this.imageDynamique.setY(this.positionY);
    }


    public ImageView getImageDynamique() {return this.imageDynamique;}

    public void update(long time){
        this.rectangleX = IndexPosX.get((int)(this.rectangleX+1)%5);
    }


}
