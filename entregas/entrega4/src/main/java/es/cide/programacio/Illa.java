package es.cide.programacio;

import java.util.Random;

public class Illa {

    private static final int MIDA_MAX = 7;
    private static final int MIDA_MIN = 3;

    private int mida;
    private Random random = new Random();
    private Pirata[] arrayPiratas;

    // Constructor
    public Illa() {
        mida = random.nextInt(MIDA_MAX - MIDA_MIN + 1) + MIDA_MIN;
        ;
        this.arrayPiratas = new Pirata[mida];
        for (int i = 0; i < arrayPiratas.length; i++) {
            this.arrayPiratas[i] = new Pirata();
        }
    }

    public Pirata vullUnPirata(int index) {
        return arrayPiratas[index];
    }

    public Pirata[] getArrayPiratas() {
        return arrayPiratas;
    }
}
