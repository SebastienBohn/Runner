package com.company;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.KeyCode;
import java.lang.Math;
import javafx.stage.Stage;
import java.util.ArrayList;

public class GameScene extends Scene {

    //Définition des attributs de la classe
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
    private double ImageFoe = 0;
    private double compteurCourse = 5;
    private double herosInvincible = 0;
    private double monteOK;
    private double compteurMontee = 0;
    private double compteurNewFoe = 0;
    private Integer indexPositionFoe = 0;
    private Stage primaryStage;

    //Définition des actions réalisées par le Timer
    private AnimationTimer Timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            heros.Update(time);
            double posXheros = heros.getPositionX();
            monteOK = heros.getMonteOK();
            if(monteOK==1 && compteurMontee==20){
                heros.setMonteOK(0);
                compteurMontee=0;
            }
            else if(monteOK==1){
                compteurMontee++;
            }
            camera.Update(time,posXheros);
            if(compteurCourse==5){
                herosInvincible = (herosInvincible+1)%2;
                ImageFoe=(ImageFoe+1)%5;
                ImageHeros=(ImageHeros+1)%3;
                heros.miseAJourHeros(time,ImageHeros);
                compteurCourse = 0;
            }
            else{
                compteurCourse++;
            }
            if(heros.getInvincibility()==0){
                for(foe f : Foe){
                    collision = heros.Rectangle2DgetHitBox(heros.getPositionX(),heros.getPositionY(),85,100,f.getPositionX(), f.getPositionY());
                    heros.isInvincible(collision);
                }
            }
            else{
                heros.setInvincibility(heros.getInvincibility()-10);
                heros.getImageDynamique().setViewport(new Rectangle2D(ImageHeros*85, heros.getAttitude()*160, 85*herosInvincible+1, 100));
            }
            miseAJourScene();
        }
    };

    //Définition du constructeur
    public GameScene(Group root, double longueur, double hauteur, Stage primaryStage){
        super(root, longueur, hauteur); //creation de la scene comme dans le main, creation directement dans le fichier scene
        this.root = root;
        this.longueur = longueur;
        this.hauteur = hauteur;
        this.camera = new Camera(100,250);
        this.fondLeft = new staticThing(0,0,100,this.hauteur, "E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\desert.png");
        this.fondRight = new staticThing(100,0,this.longueur-100,this.hauteur, "E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\desert.png");
        this.numberOfLives = new staticThing(800-140,18,120,50, "E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\pointDeVie.png");
        this.primaryStage = primaryStage;

        Timer.start();

        root.getChildren().add(fondLeft.getImageStatique());
        root.getChildren().add(fondRight.getImageStatique());
        root.getChildren().add(numberOfLives.getImageStatique());
        root.getChildren().add(heros.getImageDynamique());

        //Création de 40 ennemis
        for (int i=0;i<40;i++) {
            foe f = new foe( 800*(1+i)+800*Math.random(), 245, 0, "E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\foe.png");
            Foe.add(f);
            root.getChildren().add(f.getImageDynamique());
        }

        //Implémentation de la méthode pour faire sauter le héros
        this.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                heros.jump();
            }
        });
    }

    //Définition de la fonction qui met à jour tous les éléments présents sur l'image
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

        //Maj de tous les ennemis
        for (foe f : Foe){
            f.setPositionX(f.getPositionX()-8);
            f.miseAJourFoe(ImageFoe);
            f.getImageDynamique().setX(f.getPositionX());
        }

        //Test si le joueur a perdu et affichage de la scène de fin en conséquence
        if(heros.getPointDeVie()==0){
            heros.setPointDeVie(40);
            Group root3 = new Group();
            Scene fin = new WaitScene(root3, 800, 400, 1, this.primaryStage);
            this.primaryStage.setScene(fin);
            this.primaryStage.show();
        }
    }
}