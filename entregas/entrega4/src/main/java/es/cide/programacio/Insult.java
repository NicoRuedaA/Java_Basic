package es.cide.programacio;

import java.util.Random;

public class Insult {

    private int insult;

    public Insult() {
        this.insult = 0;
    }

    // construcotr para un insulto concreto (posicion en el array)
    public Insult(int x) {
        this.insult = x;
    }

    public int getInsulto() {
        return this.insult;
    }

    public String getTexto() {
        return Main.getText(this.insult);
    }

}
