package com.company;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.KeyCode;
import java.lang.Math;

import java.util.ArrayList;
import java.util.Random;


public class GameScene extends Scene {

    private Group root;
    private Camera camera;
    private staticThing fondLeft;
    private staticThing fondRight;
    private staticThing numberOfLives;
    private double longueur;
    private double hauteur;
    private Hero heros = new Hero(100,250,0 ,"E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\heros.png");
    private ArrayList<foe> Foe = new ArrayList<foe>();
    private Integer collision;

    private double ImageHeros = 0;
    private double compteurCourse = 5;
    private double monteOK;
    private double compteurMontee = 0;
    private double compteurNewFoe = 0;
    private Integer indexPositionFoe = 0;


    private AnimationTimer Timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            heros.Update(time);
            double posXheros = heros.getPositionX();
            monteOK = heros.getMonteOK();
            if(monteOK==1 && compteurMontee==15){
                heros.setMonteOK(0);
                compteurMontee=0;
            }
            else if(monteOK==1){
                compteurMontee++;
            }
            camera.Update(time,posXheros);
            if(compteurCourse==5){
                ImageHeros=(ImageHeros+1)%3;
                heros.miseAJourHeros(time,ImageHeros);
                compteurCourse = 0;
            }
            else{
                compteurCourse++;
            }
            if(heros.getInvincibility()==0){
                collision = 0; //heros.Rectangle2DgetHitBox(heros.getPositionX(),heros.getPositionY(),85,100,Foe.get(0).getPositionX(), Foe.get(0).getPositionY());
                heros.isInvincible(collision);
            }
            else{
                heros.setInvincibility(heros.getInvincibility()-5);
            }

            /*
            if(compteurNewFoe==5){
              //  Foe.add(new foe(heros.getPositionX()+800*(1+Math.random()),250,0,"E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\tank1.png"));
                //root.getChildren().add(Foe.get(1).getImageDynamique());
                compteurNewFoe=0;
            }
            else{
                compteurNewFoe+=1;
            }
*/

            miseAJourScene();
        }
    };



    public GameScene(Group root, double longueur, double hauteur){
        super(root, longueur, hauteur); //creation de la scene comme dans le main, creation directement dans le fichier scene
        this.root = root;
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

        for (int i=0;i<20;i++) {
            foe f = new foe( 800 * (1 + 20*Math.random()), 250, 0, "E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\tank1.png");
            Foe.add(f);
            root.getChildren().add(f.getImageDynamique());
        }

        this.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                heros.jump();
            }
        });

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
        numberOfLives.getImageStatique().setViewport(new Rectangle2D(0, 0, heros.getPointDeVie()*((numberOfLives.getLongueur()/3)+1), numberOfLives.getHauteur()));
        heros.getImageDynamique().setY(heros.getPositionY());

        for (foe f : Foe){
            f.setPositionX(f.getPositionX()-10);
            f.getImageDynamique().setX(f.getPositionX()-10);
        }
    }

}
