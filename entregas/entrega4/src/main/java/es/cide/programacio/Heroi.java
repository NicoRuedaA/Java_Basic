package es.cide.programacio;

import java.util.Scanner;

public class Heroi {

    private static final int VIDA = 10;

    private String nom;
    private int vida;
    private Insult[] arrayRespuestas;

    public Heroi() {
        this.nom = " ";
        this.vida = VIDA;
        this.arrayRespuestas = new Insult[0];
    }

    public Heroi(String s, Insult[] arrResp) {
        this.nom = s;
        this.vida = VIDA;
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
        Scanner scHeroi = new Scanner(System.in); // no hace falta cerrarlo. Basta con cerrar Scanner al final en el
                                                  // main. Si no da error
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

        return arrayRespuestas[respuesta].getTextoRespuesta();
    }

    private void mostrarRespuestas() {
        // mostramos cada respuesta del array de Insults
        // objeto insults contiene un String con su respuesta
        for (int i = 0; i < arrayRespuestas.length; i++) {
            System.out.println(arrayRespuestas[i].getTextoRespuesta());
        }
    }

    public String getNom() {
        return this.nom;
    }

    public int getVida() {
        return this.vida;
    }
}
