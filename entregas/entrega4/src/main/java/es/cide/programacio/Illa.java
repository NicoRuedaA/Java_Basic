package es.cide.programacio;

import java.util.Random;

public class Illa {

    private static final String[] nombresIsla = { "La Española", "Isla Antigua", "Icacos", "Booby Cay",
            "Waterlemon Cay" };

    // vida maxima 7
    private static final int MIDA_VARIACION = 5;
    private static final int MIDA_MIN = 3;

    private int mida, pirataActual;
    private Random random = new Random();
    private Pirata[] arrayPiratas;
    private String nomIlla;

    // Constructor
    public Illa(Insult[] arrayInsultos) {
        mida = random.nextInt(MIDA_VARIACION); // creamos una array del tamaño minimo 3, maximo 7
        // (random + 3)
        this.arrayPiratas = new Pirata[mida + MIDA_MIN];
        nomIlla = nombresIsla[mida]; // Le asignamos un nombre aleatorio a la isla
        this.pirataActual = 0;

        for (int i = 0; i < arrayPiratas.length; i++) {
            arrayPiratas[i] = new Pirata(arrayInsultos);
        }
    }

    public boolean nextPirata() {
        pirataActual++;

        return pirataActual >= arrayPiratas.length;
    }

    public Pirata vullUnPirata(int index) {
        return arrayPiratas[index];
    }

    public Pirata vullPirataActual() {
        return vullUnPirata(pirataActual);
    }

    public Pirata[] getArrayPiratas() {
        return arrayPiratas;
    }

    public int getMaxPiratas() {
        return arrayPiratas.length;
    }

    public String getNom() {
        return this.nomIlla;
    }

    public int getNumPiratas() {
        return this.arrayPiratas.length;
    }

    public Insult getInsultoActual() {
        System.out.println("Pirata actual: " + pirataActual);
        return vullPirataActual().getInsultoActual();
    }
}
