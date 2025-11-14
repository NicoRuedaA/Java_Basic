package es.cide.programacio;

import java.util.Random;

public class Pirata {
    private static final int NUM_INSULTS = 3;
    private static final int VIDA_MAX = 3;
    private static final int VIDA_MIN = 1;
    private Random random = new Random();
    private String nom;
    private int vida, vidaMax;
    private Insult insultActual;
    private Insult[] arrayInsultos;

    // un contador para el nombre del pirata
    private static int numeroPirata = 1;

    // Constructor
    public Pirata(String[][] arrIns) {

        Random random = new Random();

        // hacemos que el insulto actual sea random
        this.insultActual = new Insult(random.nextInt(3));
        // le asignamos una vida aleatoria al pirata

        this.vida = random.nextInt(VIDA_MIN, VIDA_MAX) + 1;
        this.vidaMax = this.vida;
        this.nom = "Pirata " + numeroPirata;
        numeroPirata++;
        // el nombr del pirata es su ¨numero¨

        // creamos un array de Insultos
        this.arrayInsultos = new Insult[NUM_INSULTS];

        for (int i = 0; i < arrayInsultos.length; i++) {
            boolean salir = false;
            do {

                int aux = random.nextInt(arrIns[0].length);
                if (!Main.estaUsadoElInsulto(aux)) {

                    Main.usarInsulto(aux);

                    salir = true;

                    arrayInsultos[i] = new Insult(aux);

                }
            } while (!salir);

            // indicamos que el insulto está usado
        }
    }

    public Pirata(int x, int y, int z) {

        Random random = new Random();
        this.insultActual = new Insult(random.nextInt(3));
        // no lo uso en esta version
        this.vida = random.nextInt(VIDA_MIN, VIDA_MAX) + 1;
        numeroPirata++;
        this.nom = "Pirata " + numeroPirata;
        this.arrayInsultos = new Insult[NUM_INSULTS];

        arrayInsultos[0] = new Insult(x);
        arrayInsultos[1] = new Insult(y);
        arrayInsultos[2] = new Insult(z);
    }

    public void insultar() {
        System.out.println(insultActual.getTextoInsulto());
    }

    public boolean replica(String s) {
        // comparamos le string pasado con el insulto actual
        boolean coincide = insultActual.getTextoInsulto().equals(s);
        Random random = new Random();
        // hacemos que el insulto actual sea random
        this.insultActual = new Insult(random.nextInt(3));

        return coincide;
    }

    public boolean vida() {
        boolean vivo = false;
        this.vida--;
        if (vida > 0)
            return vivo = true;
        return vivo;
    }

    // GETS Y SETS
    public String getNom() {
        return this.nom;
    }

    public int getVida() {
        return this.vida;
    }

    public int getVidaMax() {
        return this.vidaMax;
    }

    public Insult getInsultoActual() {
        return insultActual;
    }

    public Insult getInsulto(int x) {
        return this.arrayInsultos[x];

    }

}
