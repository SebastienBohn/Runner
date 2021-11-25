package com.company;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;


public class WaitScene extends Scene {

    //Definition des attributs de la classe
    private Integer choix;
    private staticThing fond;
    private double longueur;
    private double hauteur;
    private Stage primaryStage;

    //Définition du constructeur
    public WaitScene(Group root, double longueur, double hauteur, Integer choix, Stage primaryStage) {
        super(root, longueur, hauteur); //creation de la scene comme dans le main, creation directement dans le fichier scene
        this.choix = choix;
        this.longueur = longueur;
        this.hauteur = hauteur;
        this.primaryStage = primaryStage;

        //Affichage de la scène de début
        if(this.choix==0){
            this.fond = new staticThing(0,0,this.longueur,this.hauteur, "E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\debut.png");
            root.getChildren().add(this.fond.getImageStatique());
        }

        //Affichage de la scène de fin
        if(this.choix==1){
            this.fond = new staticThing(0,0,this.longueur,this.hauteur, "E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\fin.png");
            root.getChildren().add(this.fond.getImageStatique());
        }

        //Les deux scènes utilisent la même touche pour passer à la GameScene
        this.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                Group root2 = new Group();
                Scene jeu = new GameScene(root2, 800, 400, this.primaryStage);
                this.primaryStage.setScene(jeu);
                this.primaryStage.show();
            }
        });
    }
}