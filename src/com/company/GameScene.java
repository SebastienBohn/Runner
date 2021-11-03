package com.company;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.geometry.Rectangle2D;

import java.awt.*;


public class GameScene extends Scene {

    private Camera camera;
    private staticThing fondLeft;
    private staticThing fondRight;
    private staticThing numberOfLives;
    private double longueur;
    private double hauteur;
    private Hero heros = new Hero(100,250,0 ,"E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\heros.png");


    private double ImageHeros = 0;
    private double compteur = 5;

    private AnimationTimer Timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            heros.Update(time);
            double posXheros = heros.getPositionX();
            camera.Update(time,posXheros);
            if(compteur==5){
                ImageHeros=(ImageHeros+1)%3;
                heros.miseAJourHeros(time,ImageHeros);
                compteur = 0;
            }
            else{
                compteur++;
            }
            miseAJourScene();
        }
    };



    public GameScene(Group root, double longueur, double hauteur){
        super(root, longueur, hauteur); //creation de la scene comme dans le main, creation directement dans le fichier scene
        this.longueur = longueur;
        this.hauteur = hauteur;
        this.camera = new Camera(100,250);

        this.fondLeft = new staticThing(0,0,100,this.hauteur, "E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\desert.png");
        this.fondRight = new staticThing(100,0,this.longueur-100,this.hauteur, "E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\desert.png");
        this.numberOfLives = new staticThing(800-140,18,120,50, "E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\pointDeVie.png");

        Timer.start();

        root.getChildren().add(fondLeft.getImageStatique());
        root.getChildren().add(fondRight.getImageStatique());
        root.getChildren().add(numberOfLives.getImageStatique());
        root.getChildren().add(heros.getImageDynamique());

        miseAJourScene();

    }

    public void miseAJourScene(){
        //Maj des fonds Left,Right et NumberOfLives :
        double positionXCamera = camera.getX();
        double decalage = positionXCamera%800;
        fondLeft.getImageStatique().setViewport(new Rectangle2D(decalage, 0, 800, fondLeft.getHauteur()));
        fondRight.getImageStatique().setX(800-decalage);
        fondRight.getImageStatique().setViewport(new Rectangle2D(0, 0, decalage, fondRight.getHauteur()));
        fondRight.getImageStatique().setX(800-decalage);
        numberOfLives.getImageStatique().setViewport(new Rectangle2D(0, 0, numberOfLives.getLongueur(), numberOfLives.getHauteur()));
    }




}
