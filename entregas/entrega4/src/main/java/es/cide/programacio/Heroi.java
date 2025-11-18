package es.cide.programacio;

import java.util.Scanner;

public class Heroi {

    private static final int VIDA = 10;

    private String nom;
    private int vida;
    private Insult[] arrayRespuestas;

    public Heroi() {
        this.nom = " ";
        this.vida = VIDA;
        this.arrayRespuestas = new Insult[0];
    }

    public Heroi(String s, Insult[] arrResp) {
        this.nom = s;
        this.vida = VIDA;
        this.arrayRespuestas = arrResp;
    }

    public boolean vida() {
        boolean vivo = false;
        this.vida--;
        if (this.vida > 0)
            vivo = true;
        return vivo;
    }

    public String defensar() {
        Scanner scHeroi = new Scanner(System.in); // no hace falta cerrarlo. Basta con cerrar Scanner al final en el
                                                  // main. Si no da error
        UI.escribirLento("¿Qué le contestas? (1-10)", 15);
        mostrarRespuestas();
        int respuesta = getInputValidado(scHeroi);

        return arrayRespuestas[respuesta].getTextoRespuesta();
    }

    private void mostrarRespuestas() {
        // mostramos cada respuesta del array de Insults
        // objeto insults contiene un String con su respuesta

        for (int i = 0; i < arrayRespuestas.length; i++) {
            UI.escribirLento((i + 1) + " " + arrayRespuestas[i].getTextoRespuesta(), 5);
            System.out.println();
        }
    }

    public String getNom() {
        return this.nom;
    }

    public int getVida() {
        return this.vida;
    }

    private int getInputValidado(Scanner scan) {
        int res = -1;
        System.out.println();

        while (res < 1 || res > 10) {
            System.out.println();
            UI.escribirLento(("Introdueix la teva resposta 1-10: "), 15);
            try {
                res = scan.nextInt();
                if (res < 1 || res > 10)
                    UI.escribirLento(("Fuera de rango:"), 15);
            } catch (Exception e) {
                scan.next(); // limpiamos buffer
            }

            System.out.println();
        }

        return res - 1;
    }
}
