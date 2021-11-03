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
        Scene scene = new GameScene(root, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

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