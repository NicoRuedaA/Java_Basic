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

    public boolean vida(){
        this.vida --;
        System.out.println(this.vida);
        if(this.vida>0) return true;
        return false; 
    }

    public String defensar(){
        Scanner scHeroi = new Scanner(System.in);
        int res = 0;
        Insult insult2 = new Insult(), insult3 = new Insult();

        System.out.println(insult2.getInsultText());
        System.out.println(insult3.getInsultText());

        while (res<1 || res>3){
            //try {
            System.out.println("Introdueix la teva resposta 1-3");
            res = scHeroi.nextInt();

            //} 
            /*catch (InputMismatchException e) {
                System.out.println("Error");
                //sc.nextLine(); 
            }*/
        }


        //scHeroi.close();

        switch (res) {
            case 1:
            default:
                return " ";
            case 2:
                return insult2.getInsultText();
            case 3:
                return insult3.getInsultText(); 
        }
    }
}
