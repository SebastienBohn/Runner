package com.company;

// add any usefull package line

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class Main extends Application{

    public void start(Stage primaryStage){

        primaryStage.setTitle("BOHN_Sebastien_Runner");
        Group root = new Group();
        Scene scene = new GameScene(root, 800, 400, 200,250);
        primaryStage.setScene(scene);
        primaryStage.show();

        AnimatedThing Robot1 = new AnimatedThing(200,250,0,"E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\heros.png");
        root.getChildren().add(Robot1.getImageDynamique());
        AnimatedThing Robot2 = new AnimatedThing(300,250,1,"E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\heros.png");
        root.getChildren().add(Robot2.getImageDynamique());
        AnimatedThing Robot3 = new AnimatedThing(400,250,0 ,"E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\heros.png");
        root.getChildren().add(Robot3.getImageDynamique());
        AnimatedThing Robot4 = new AnimatedThing(500,250,1,"E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\heros.png");
        root.getChildren().add(Robot4.getImageDynamique());
        /*
        Image spriteSheet = new Image("E:\\Documents\\ENSEA\\2A\\MajeureInfo\\ProgObjetJava\\Runner\\heros.png");
        ImageView sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(20, 0, 65, 100));
        sprite.setX(200);
        sprite.setY(250);
        root.getChildren().add(sprite);
        */


    }
    public static void main(String[] args) {
        launch(args);
        // write your code here
    }
}