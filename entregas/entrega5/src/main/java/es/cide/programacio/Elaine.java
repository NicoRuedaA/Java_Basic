package es.cide.programacio;

public class Elaine extends Heroi {
    // vida (inicial) constante
    private static final int VIDA = 10;

    public Elaine(Insult[] arrResp) {
        super("Elaine", VIDA, arrResp);
        sayHello();
    }

}
