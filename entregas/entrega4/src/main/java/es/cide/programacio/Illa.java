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
        mida = random.nextInt(MIDA_MIN, MIDA_MAX) + 1;
        this.arrayPiratas = new Pirata[mida];
    }

    public Pirata vullUnPirata(int index){
        return arrayPiratas[index];
    }
}
