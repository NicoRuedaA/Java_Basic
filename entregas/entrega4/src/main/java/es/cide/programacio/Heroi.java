package es.cide.programacio;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Heroi {

    private String nom;
    private int vida;
    private String[] arrayRespuestas;

    public Heroi() {
        this.nom = " ";
        this.vida = 0;
        this.arrayRespuestas = new String[0];
    }

    public Heroi(String s, int v, String[] arrResp) {
        this.nom = s;
        this.vida = v;
        this.arrayRespuestas = arrResp;
    }

    public boolean vida() {
        boolean vivo = false;
        this.vida--;
        if (this.vida > 0)
            vivo = true;
        return vivo;
    }

    public String defensar() {
        Scanner scHeroi = new Scanner(System.in);
        System.out.println("¿Qué le contestas? (1-10)");
        mostrarRespuestas();
        int respuesta = scHeroi.nextInt();
        System.out.println();

        while (respuesta < 1 || respuesta > 10) {
            System.out.println();
            System.out.println("Introdueix la teva resposta 1-10");
            respuesta = scHeroi.nextInt();
            System.out.println();
        }

        return arrayRespuestas[respuesta];
    }

    private void mostrarRespuestas() {
        for (int i = 0; i < arrayRespuestas.length; i++) {
            System.out.println(arrayRespuestas[i]);
        }
    }

    public String getNom() {
        return this.nom;
    }

    public int getVida() {
        return this.vida;
    }
}
