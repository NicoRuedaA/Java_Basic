package es.cide.programacio;

import java.util.Random;

public class Pirata {
    private static final int NUM_INSULTS = 3;
    private static final int VIDA_MAX = 3;
    private static final int VIDA_MIN = 1;
    private Random random = new Random();
    private String nom;
    private int vida, insultActual;
    private Insult[] arrInsults;

    private int numeroPirata;
    private int contador = 0;

    // Constructor
    public Pirata() {
        this.vida = random.nextInt(VIDA_MIN, VIDA_MAX) + 1;
        this.numeroPirata = contador++;
        this.nom = "Pirata " + numeroPirata;
        this.arrInsults = new Insult[NUM_INSULTS];
        this.insultActual = 0;
        // System.out.println("Creando pirata con vida: " + vida);
        for (int i = 0; i < arrInsults.length; i++) {
            arrInsults[i] = new Insult();

        }
    }

    public Insult insultar() {
        int numRandom = random.nextInt(NUM_INSULTS);
        Insult ins = this.arrInsults[numRandom];
        insultActual = numRandom;
        return ins;
    }

    public boolean replica(String s) {
        Insult insultComparar = arrInsults[insultActual];
        boolean correcto = insultComparar.respuestaCorrecta(s);
        return correcto;
    }

    public boolean vida() {
        this.vida--;
        if (vida > 0)
            return true;
        return false;
    }

    // GETS Y SETS
    public String getNom() {
        return this.nom;
    }

    public int getVida() {
        return this.vida;
    }

    public Insult getInsultActual() {
        return this.arrInsults[insultActual];
    }

    public Insult getInsult(int x) {
        return this.arrInsults[x];

    }

}
