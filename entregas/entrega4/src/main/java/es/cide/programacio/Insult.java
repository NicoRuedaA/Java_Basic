package es.cide.programacio;

import java.util.Random;

public class Insult {

    private Random random = new Random();
    private int insult;

    public Insult() {

        this.insult = random.nextInt(Main.arrayInsultos.length);
    }

    // construcotr para un insulto concreto (posicion en el array)
    public Insult(int x) {
        // comprobar
        this.insult = x;
    }

    /*
     * //creamos y devolvemos un insult aleatorio
     * public Insult getInsultAleatori(){
     * Insult nouInsult = new Insult(random.nextInt(arrayInsultos.length));
     * return nouInsult;
     * }
     */

    public boolean respuestaCorrecta(String s) {
        return s.equals(Main.arrayRespuestas[this.insult]);
    }

    public String getResposta(int x) {
        return Main.arrayRespuestas[x];
    }

    public String getInsultText() {
        return Main.arrayInsultos[this.insult];
    }

}
