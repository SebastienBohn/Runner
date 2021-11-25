package com.company;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public class Hero extends AnimatedThing {

    private double positionX;
    private double positionY;
    private Integer attitude;
    private String fileName;
    private ImageView imageHeros;
    private double rectangleX;
    private double rectangleY;
    private double deplacementY = 0;
    private double monteOK = 0;
    private double invincibility;
    private Integer pointDeVie = 3;

    public Hero(double positionX, double positionY, Integer attitude, String fileName){
        super(positionX,positionY,attitude, fileName);
        this.positionX = positionX;
        this.positionY = positionY;
        this.attitude = attitude;
        this.fileName = fileName;
        this.imageHeros = getImageDynamique();
        this.imageHeros.setX(this.positionX);
        this.imageHeros.setY(this.positionY);
    }

    public void miseAJourHeros(long time, double ImageHeros){
        //Maj de l'attitude du heros :
        if(this.deplacementY<0){
            ImageHeros=0;
            this.attitude=1;
        }
        else if(this.deplacementY>0 && this.positionY<250){
            ImageHeros=1;
            this.attitude=1;
        }
        else{
            this.attitude=0;
        }

        //Maj de l'image du heros :
        this.imageHeros.setViewport(new Rectangle2D(ImageHeros*85, this.attitude*160, 85, 100));

    }

    public void jump(){
        //On monte seulement si le joueur est au sol, on n'additionne pas les sauts :
        if(this.positionY>=250){
            this.deplacementY-=11;
            this.monteOK=1;
        }
    }

    //Définition de la méthode qui met à jour la position du héros sur l'image
    public void Update (long time) {
        //Le héros avance
        this.positionX = (this.positionX + 6);

        //On met les effets de la gravité :
        this.positionY+=this.deplacementY;
        if(this.monteOK==0){
            this.deplacementY=8;
        }

        //On définit le sol qui se situe à 50 pixels:
        if(this.positionY>=250){
            this.positionY=250;
            this.deplacementY=0;
        }

    }

    public void isInvincible(Integer collision){
        if(collision==1){
            this.invincibility=1000;
            this.pointDeVie-=1;
        }
    }


    //Fonctions get et set
    public double getMonteOK() {return monteOK;}
    public double getPositionX() {return positionX;}
    public double getPositionY() {return positionY;}
    public Integer getAttitude() {return attitude;}
    public double getInvincibility() {return invincibility;}
    public Integer getPointDeVie() {return pointDeVie;}
    public void setMonteOK(double monteOK) {this.monteOK = monteOK;}
    public void setInvincibility(double invincibility) {this.invincibility = invincibility;}
    public void setPointDeVie(Integer pointDeVie) {this.pointDeVie = pointDeVie;}
}
