package com.company;

public class Camera {

    //Définition des attributs de la classe
    private double x=0;
    private double y=0;

    //Définition du constructeur
    public Camera(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    //Définition de la méthode qui met à jour la position de la camera par rapport au heros
    public void Update(long time, double posXheros){
        this.x = posXheros;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
    public double getX() {return x;}
    public double getY() {return y;}
}
