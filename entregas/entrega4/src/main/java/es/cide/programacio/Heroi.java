package es.cide.programacio;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Heroi {

    private String nom;
    private int vida;

    public Heroi() {
        this.nom = " ";
        this.vida = 10;
    }

    public Heroi(String s, int v) {
        this.nom = s;
        this.vida = v;
    }

    public boolean vida() {
        this.vida--;
        System.out.println("heroi vida: " + this.vida);
        if (this.vida > 0)
            return true;
        return false;
    }

    public String defensar(String[] arrIns, Insult insPirata) {
        Random random = new Random();
        Scanner scHeroi = new Scanner(System.in);
        int respuesta = 0;
        // obtenemos el insulto, lo guardamos en una array y creamos 2 aleatorias

        boolean salir = false;
        int x, y;

        do {

            x = random.nextInt(arrIns.length);

            if (x != insPirata.getInsulto())
                salir = true;
        } while (!salir);

        do {
            y = random.nextInt(arrIns.length);
            if (y != insPirata.getInsulto())
                salir = true;
        } while (!salir);

        Insult[] arrayInsultosPirata = {
                insPirata,
                // hacer que sea diferente a estos dos
                new Insult(x),
                new Insult(y),
        };
        // mezclamos el array para imprimirlas por pantalla en un orden aleatorio con
        // Fisher-Yates
        for (int k = arrayInsultosPirata.length - 1; k > 0; k--) {
            int l = random.nextInt(k + 1);
            Insult aux = arrayInsultosPirata[k];
            arrayInsultosPirata[k] = arrayInsultosPirata[l];
            arrayInsultosPirata[l] = aux;
        }

        // usar for. Obtener 3 como constante. Modifica en el for
        System.out.println(arrayInsultosPirata[0].getTexto());
        System.out.println(arrayInsultosPirata[1].getTexto());
        System.out.println(arrayInsultosPirata[2].getTexto());

        System.out.println(insPirata.getTexto());
        while (respuesta < 1 || respuesta > 3) {
            // try {
            System.out.println();
            System.out.println("Introdueix la teva resposta 1-3");
            respuesta = scHeroi.nextInt();
            // }
            /*
             * catch (InputMismatchException e) {
             * System.out.println("Error");
             * //sc.nextLine();
             * }
             */
        }
        // scHeroi.close();
        // return arrIns[respuesta].equals(arrIns[insPirata]);
        System.out.println("respuesta elegida: " + arrayInsultosPirata[respuesta - 1].getTexto());
        return arrayInsultosPirata[respuesta - 1].getTexto();
    }
}
