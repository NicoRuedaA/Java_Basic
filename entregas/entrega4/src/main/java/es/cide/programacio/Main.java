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

        boolean acabarJuego = false; // variables boolean
        String heroiNom;

        UI.titulo(illa); // imprimimos el título "The Secret of Monkey Island"

        heroiNom = sc.nextLine(); // pedimos el nombre del jugador y creamos un Heroi con este
        heroi = new Heroi(heroiNom, arrayInsultos);

        UI.escribirLento("Nuestro héroe " + heroi.getNom() + " se encuentra con " + illa.getNumPiratas() + " piratas",
                40);

        UI.limpiarConsola();

        while (!acabarJuego) {
            // Mostramos una UI con las vidas del jugador y pirata
            UI.sprites(heroi.getVida(), 10, illa.vullPirataActual().getNom(), illa.vullPirataActual().getVida(),
                    illa.vullPirataActual().getVidaMax(), heroi.getNom(), illa.getNumPiratas());
            illa.vullPirataActual().insultar(); // mostramos el insulto
            String respuestaElegida = heroi.defensar(); // mostramos las posibles respuestas, eelgimos una y devolvemos
                                                        // el String de este
            boolean respuesta = illa.vullPirataActual().replica(respuestaElegida); // llamamos la funcion replica del
                                                                                   // pirata actual
            UI.limpiarConsola();

            if (respuesta) {
                if (!illa.vullPirataActual().vida()) {

                    if (!illa.nextPirata())

                        acabarJuego = true;
                    UI.finDelJuego(true);
                }
            } else if (!heroi.vida()) {
                acabarJuego = true;
                UI.finDelJuego(false);
            }
        }

        sc.close();
    }

}
