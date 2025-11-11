package es.cide.programacio;

import java.util.Random;

public class Pirata {
    private static final int NUM_INSULTS = 3;
    private static final int VIDA_MAX = 3;
    private static final int VIDA_MIN = 1;
    private Random random = new Random();
    private String nom;
    private int vida, insultActual;
    private Insult[] arrayInsultos;

    // un contador para el nombre del pirata
    private int numeroPirata = 1;

    // Constructor
    public Pirata(String[][] arrIns) {
        this.insultActual=0;
        Random random = new Random();
        // le asignamos una vida aleatoria al pirata
        this.vida = random.nextInt(VIDA_MIN, VIDA_MAX) + 1;
        numeroPirata++;
        // el nombr del pirata es su ¨numero¨
        this.nom = "Pirata " + numeroPirata;
        // creamos un array de Insultos
        this.arrayInsultos = new Insult[NUM_INSULTS];
        
        for (int i = 0; i < arrayInsultos.length; i++) {
            boolean salir = false;
            System.out.println(arrIns.length);
            do {
                int aux = random.nextInt(arrIns.length);
                if (!Main.estaUsadoElInsulto(aux)) {
                    Main.usarInsulto(aux);
                    salir = true;
                    arrayInsultos[i] = new Insult(aux);
                }
            } while (!salir);
            System.out.println("Aqui no peta");
            // indicamos que el insulto está usado
        }
    }

    public Pirata(int x, int y, int z) {
        this.insultActual=0;
        // no lo uso en esta version
        this.vida = random.nextInt(VIDA_MIN, VIDA_MAX) + 1;
        numeroPirata++;
        this.nom = "Pirata " + numeroPirata;
        this.arrayInsultos = new Insult[NUM_INSULTS];
        // this.insultActual = 0;
        arrayInsultos[0] = new Insult(x);
        arrayInsultos[1] = new Insult(y);
        arrayInsultos[2] = new Insult(z);
    }

    public Insult insultar() {
        int numRandom = random.nextInt(NUM_INSULTS);
        Insult ins = this.arrayInsultos[numRandom];
        return ins;
    }

    public boolean replica(String s) {
        boolean coincide = arrayInsultos[insultActual].equals(s); 
        this.insultActual++;
        return coincide;
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
        return arrayInsultos[insultActual];
    }

    public Insult getInsult(int x) {
        return this.arrayInsultos[x];

    }

}
