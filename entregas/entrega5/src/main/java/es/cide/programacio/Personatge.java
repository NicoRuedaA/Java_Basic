package es.cide.programacio;

public abstract class Personatge implements Fight, Speak {

    // variables para interactuar durante el juego
    protected String nom;
    protected int vida;

    public Personatge() {
        this.nom = "";
        this.vida = 0;
    }

    public Personatge(String nom, int vida) {
        this.nom = nom;
        this.vida = vida;
    }

    public abstract boolean vida();
}