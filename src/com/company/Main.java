package com.company;

// add any usefull package line

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.KeyCode;



public class Main extends Application{

    public void start(Stage primaryStage){

        primaryStage.setTitle("BOHN_Sebastien_Runner");
        Group root1 = new Group();
        Scene debut = new WaitScene(root1, 800, 400, 0, primaryStage);

        //Group root2 = new Group();
        //Scene jeu = new GameScene(root2, 800, 400, primaryStage);

        //Group root3 = new Group();
        //Scene fin = new WaitScene(root3, 800, 400, 0, primaryStage);

        primaryStage.setScene(debut);
        primaryStage.show();
        /*debut.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                primaryStage.setScene(jeu);
                primaryStage.show();
            }
        });
*/

    }


    public static void main(String[] args) {
        launch(args);
        // write your code here
    }
}