package es.cide.programacio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Heroi{
    
    private String nom;
    private int vida;

    public Heroi(){
        this.nom = " ";
        this.vida = 10;
    }

    public Heroi(String s, int v){
        this.nom = s;
        this.vida = v;
    }

    /*public String defensar(){
        String respuesta1, respuesta2, respuesta3 = " ";
        int res = 0;

        Pirata pirataActual = new Pirata();
        pirataActual.getPirataActual();
        pirataActual.getInsultActual();
        
        Insult insultRandom = new Insult(); Insult insultRandom2 = new Insult();


        /*while (res<1 || res>3){
            try {
            System.out.println("Introdueix la teva resposta 1-3");
            res = sc.nextInt();
        } 
        catch (InputMismatchException e) {
            System.out.println("Error");
            //sc.nextLine(); 
        }
    }


        return respuesta3;
    }

    public boolean vida(){
        this.vida --;
        if(vida>0) return true;
        return false; 
    }*/
}
