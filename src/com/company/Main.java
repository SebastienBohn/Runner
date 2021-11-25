package com.company;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application{

    public void start(Stage primaryStage){
        primaryStage.setTitle("BOHN_Sebastien_Runner");
        Group root1 = new Group();
        Scene debut = new WaitScene(root1, 800, 400, 0, primaryStage);
        primaryStage.setScene(debut);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        // write your code here
    }
}