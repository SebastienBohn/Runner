package com.company;

import javafx.scene.Group;
import javafx.scene.Scene;


public class WaitScene extends Scene {

    private Integer choix;
    private staticThing fond;
    private double longueur;
    private double hauteur;


    public WaitScene(Group root, double longueur, double hauteur, Integer choix) {
        super(root, longueur, hauteur); //creation de la scene comme dans le main, creation directement dans le fichier scene
        this.choix = choix;
        this.longueur = longueur;
        this.hauteur = hauteur;

        if(this.choix==0){
            this.fond = new staticThing(0,0,this.longueur,this.hauteur, "E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\debut.png");
            root.getChildren().add(this.fond.getImageStatique());
        }





    }
}
