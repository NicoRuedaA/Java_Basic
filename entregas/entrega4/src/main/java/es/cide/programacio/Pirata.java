package es.cide.programacio;

import java.util.Random;

public class Pirata {
    private static final int NUM_INSULTS = 3;
    private static final int VIDA_MAX = 3;
    private static final int VIDA_MIN = 1;
    private String nom;
    private int vida, vidaMax;
    private Insult insultActual;
    private Insult[] arrayInsultos;

    private static int numeroPirata = 1; // un contador estatico para el nombre del pirata

    // Constructor
    public Pirata(Insult[] arrIns) {

        Random random = new Random();

        this.vida = random.nextInt(VIDA_MIN, VIDA_MAX) + 1; // Le asignamos una vida aleatoria al pirata
        this.vidaMax = this.vida; // guardamos esta como vida maxima para crear un contador "el pirata tiene 6
                                  // vidas de 10"
        this.nom = "Pirata " + numeroPirata; // declaramos el nombre del pirata según su numero
        numeroPirata++;
        // creamos un array de Insultos
        this.arrayInsultos = new Insult[NUM_INSULTS];

        int x, y, z; // creamos 3 int aleatorios para obtener 3 insultos aleatorios del array pasado
        x = random.nextInt(arrIns.length);
        do {
            y = random.nextInt(arrIns.length);
        } while (y == x);
        do {
            z = random.nextInt(arrIns.length);
        } while ((z == x) || (z == x));

        // insertamos los insultos en la lista
        arrayInsultos[0] = new Insult(arrIns[x].getTextoInsulto(), arrIns[x].getTextoRespuesta());
        arrayInsultos[1] = new Insult(arrIns[y].getTextoInsulto(), arrIns[y].getTextoRespuesta());
        arrayInsultos[2] = new Insult(arrIns[z].getTextoInsulto(), arrIns[z].getTextoRespuesta());

        this.insultActual = arrayInsultos[random.nextInt(NUM_INSULTS)];
    }

    public void insultar() { // devuelve el string del insulto actual
        UI.escribirLento((this.nom + ": " + insultActual.getTextoInsulto()), 15);
        System.out.println();
    }

    public boolean replica(String s) {

        // comparamos el string pasado conla respuesta del insulto actual
        boolean coincide = insultActual.getTextoRespuesta().equals(s);
        Random random = new Random(); // hacemos que el insulto actual sea uno
                                      // aleatorio de los 3 que contiene
        this.insultActual = arrayInsultos[random.nextInt(NUM_INSULTS)];
        if (coincide)
            UI.escribirLento("RESPUESTA CORRECTA", 50);
        else
            UI.escribirLento("RESPUESTA INCORRECTA", 50);
        System.out.println();
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
        if (x >= NUM_INSULTS) {
            UI.escribirLento("X fuera de rango", 10);
            return this.arrayInsultos[0];
        }
        return this.arrayInsultos[x];

    }

}
