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

    /*
     * //creamos y devolvemos un insult aleatorio
     * public Insult getInsultAleatori(){
     * Insult nouInsult = new Insult(random.nextInt(arrayInsultos.length));
     * return nouInsult;
     * }
     */

    /*
     * public boolean respuestaCorrecta(String s) {
     * return s.equals(Main.getRespuesta(this.insult));
     * }
     * 
     * public String getResposta(int x) {
     * return Main.getRespuesta(this.insult);
     * }
     */

    public int getInsulto() {
        return this.insult;
    }

    public String getTexto() {
        return Main.getText(this.insult);
    }

}
