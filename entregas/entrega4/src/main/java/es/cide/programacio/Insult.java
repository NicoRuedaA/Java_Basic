package es.cide.programacio;

public class Insult {

    // private int pos;
    private String textoInsult;
    private String textoRespuesta;

    public Insult() {
        this.textoRespuesta = " ";
        this.textoInsult = " ";
    }

    // construcotr para un insulto concreto (posicion en el array)
    public Insult(String s, String x) {
        this.textoInsult = s;
        this.textoRespuesta = x;
    }

    public String getTextoInsulto() {
        return this.textoInsult;
    }

    public String getTextoRespuesta() {
        return this.textoRespuesta;
    }

}
