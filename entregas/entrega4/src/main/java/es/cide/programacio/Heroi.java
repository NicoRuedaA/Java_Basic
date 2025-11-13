package es.cide.programacio;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Heroi {

    private String nom;
    private int vida;

    public Heroi() {
        this.nom = " ";
        this.vida = 10;
    }

    public Heroi(String s, int v) {
        this.nom = s;
        this.vida = v;
    }

    public boolean vida() {
        boolean vivo = false;
        this.vida--;
        if (this.vida > 0) vivo = true;
        return vivo;
    }

    public String defensar(String[][] arrIns, Insult insPirata) {
        
        Random random = new Random();
        Scanner scHeroi = new Scanner(System.in);
        int respuesta = 0, x, y;;
        boolean salir = false;

        //generamos 2 numeros aleatorios para los intultos. Nos aseguramos que no sean igual a la respuesta generada
        do {
            x = random.nextInt(arrIns[0].length);
            if (x != insPirata.getInsulto())
                salir = true;
        } while (!salir);

        do {
            y = random.nextInt(arrIns[0].length);
            if (y != insPirata.getInsulto())
                salir = true;
        } while (!salir);

        Insult[] arrayInsultosPirata = {
                insPirata,
                new Insult(x),
                new Insult(y),
        };
        
        // mezclamos el array para imprimirlas por pantalla en un orden aleatorio con
        // Fisher-Yates
        for (int k = arrayInsultosPirata.length - 1; k > 0; k--) {
            int l = random.nextInt(k + 1);
            Insult aux = arrayInsultosPirata[k];
            arrayInsultosPirata[k] = arrayInsultosPirata[l];
            arrayInsultosPirata[l] = aux;
        }
        
        // usar for. Obtener 3 como constante. Modifica en el for
        System.out.println(arrayInsultosPirata[0].getTextoRespuesta());
        System.out.println(arrayInsultosPirata[1].getTextoRespuesta());
        System.out.println(arrayInsultosPirata[2].getTextoRespuesta());

        System.out.println();
        System.out.println("insulto correcto " + insPirata.getTextoRespuesta());
        while (respuesta < 1 || respuesta > 3) {
            System.out.println();
            System.out.println("Introdueix la teva resposta 1-3");
            respuesta = scHeroi.nextInt();
            System.out.println();
        }
        
        System.out.println("respuesta elegida: " + arrayInsultosPirata[respuesta - 1].getTextoInsulto());
        
        return arrayInsultosPirata[respuesta - 1].getTextoInsulto();
    }

    /**************** */
    public String getNom(){
        return this.nom;
    }

    public int getVida(){
        return this.vida;
    }
}
