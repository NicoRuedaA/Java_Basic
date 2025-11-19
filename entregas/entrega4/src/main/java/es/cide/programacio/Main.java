/*
 * Nicolás Daniel Rueda Araque
 * 42313237e
 * 05/11/2025
 */

package es.cide.programacio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Insult[] arrayInsultos = InsultArray.getInsults(); // clase para guardar arrays
        Illa illa = new Illa(arrayInsultos);
        Heroi heroi;

        UI.titulo(illa); // imprimimos el título "The Secret of Monkey Island"

        String heroiNom;
        heroiNom = sc.nextLine(); // pedimos el nombre del jugador y creamos un Heroi con este
        heroi = new Heroi(heroiNom, arrayInsultos);

        UI.escribirLento("Nuestro héroe " + heroi.getNom() + " se encuentra con " + illa.getNumPiratas() + " piratas",
                40);
        UI.pausa(2000);
        UI.limpiarConsola();

        boolean acabarJuego = false; // variables boolean
        while (!acabarJuego) {
            // Mostramos una UI con las vidas del jugador y pirata
            UI.sprites(heroi.getVida(), 10, illa.vullPirataActual().getNom(), illa.vullPirataActual().getVida(),
                    illa.vullPirataActual().getVidaMax(), heroi.getNom(), illa.getNumPiratas());

            String insulto = illa.vullPirataActual().insultar(); // mostramos el insulto

            UI.escribirLento(illa.vullPirataActual().getNom() + ": " + insulto, 15);

            String respuestaElegida = heroi.defensar(); // mostramos las posibles respuestas, eelgimos una y devolvemos
                                                        // el String de este
            boolean respuesta = illa.vullPirataActual().replica(respuestaElegida); // llamamos la funcion replica del
                                                                                   // pirata actual

            UI.animarGolpe();
            UI.pausa(1000);
            UI.limpiarConsola();

            if (respuesta) {
                if (!illa.vullPirataActual().vida()) {

                    if (!illa.nextPirata()) {
                        acabarJuego = true;
                        UI.finDelJuego(true);
                    }
                }
            } else if (!heroi.vida()) {
                acabarJuego = true;
                UI.finDelJuego(false);
            }
        }

        sc.close();
    }

}
