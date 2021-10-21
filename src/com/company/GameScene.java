package com.company;

import javafx.scene.Scene;
import javafx.scene.Group;

public class GameScene extends Scene {



    public GameScene(Group root, Integer x, Integer y){
        super(root);
        Camera camera = new Camera(x,y);

    }






}
