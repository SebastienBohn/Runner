package com.company;

import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;

public class GameScene extends Scene {

    private staticThing fondLeft;
    private staticThing fondRight;
    private double longueur;
    private double hauteur;
    private Camera camera;

    public GameScene(Group root, double longueur, double hauteur, Integer x, Integer y){
        super(root, longueur, hauteur); //creation de la scene comme dans le main, creation directement dans le fichier scene
        this.camera = new Camera(x,y);
        this.fondLeft = new staticThing(0,0, camera.getX(),hauteur, "E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\desert.png");
        this.fondRight = new staticThing(0,0, longueur-camera.getX(),hauteur, "E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\desert.png");
        this.longueur = longueur;
        this.hauteur = hauteur;
        root.getChildren().add(fondLeft.getBackground());
        root.getChildren().add(fondRight.getBackground());
        DispositionBackground();

    }


    public void DispositionBackground(){ //Pour mettre les fonds au bon endroit sur la scene
        this.fondLeft.getBackground().setViewport(new Rectangle2D(0, 0, this.camera.getX(),this.hauteur));
        this.fondRight.getBackground().setViewport(new Rectangle2D(this.camera.getX(),0, this.longueur-this.camera.getX(),this.hauteur));
        this.fondRight.getBackground().setX(this.camera.getX());
    }

}
