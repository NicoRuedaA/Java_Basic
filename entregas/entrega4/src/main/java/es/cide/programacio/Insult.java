package es.cide.programacio;

public class Insult {

    // private int pos;
    // final porque no varian una vez creadas
    private final String textoInsulto;
    private final String textoRespuesta;

    public Insult() {
        this.textoRespuesta = "";
        this.textoInsulto = "";
    }

    // constructor para un insulto concreto (posicion en el array)
    public Insult(String textoInsulto, String textoRespuesta) {
        this.textoInsulto = textoInsulto;
        this.textoRespuesta = textoRespuesta;
    }

    public String getTextoInsulto() {
        return this.textoInsulto;
    }

    public String getTextoRespuesta() {
        return this.textoRespuesta;
    }

}
