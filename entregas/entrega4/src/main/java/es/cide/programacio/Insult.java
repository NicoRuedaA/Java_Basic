package es.cide.programacio;

import java.util.Random;

public class Insult {

    private int pos;
    private String textoInsult;

    public Insult() {
        this.pos = 0;
        this.textoInsult = " ";
    }

    // construcotr para un insulto concreto (posicion en el array)
    public Insult(String s, int x) {
        this.pos = x;
        this.textoInsult = s;
    }

    public int getInsulto() {
        // devuelve la posición
        return this.pos;
    }

    public String getTextoInsulto() {
        return this.textoInsult;
    }

}
