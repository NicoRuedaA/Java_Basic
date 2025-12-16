/*
 * Nicolás Daniel Rueda Araque
 * 42313237e
 * 05/11/2025
 */

package es.cide.programacio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // abrimos el scanner

        Illa illa = new Illa(InsultArray.getInsults());// creamos la isla pasandole nuestra array estatica de objetos
                                                       // "insult"
        boolean respuestaEsCorrecta, acabarJuego = false, entradaValida = false; // variables para interactuar durante
                                                                                 // el juego
        String respuestaElegida;

        // imprimimos el título "The Secret of Monkey Island"
        UI.titulo(illa);

        // creamos un heroe (vacío)
        Heroi heroi;

        // eleccion del personaje
        int eleccionPersonaje = 100;

        while (!entradaValida || eleccionPersonaje != 1 && eleccionPersonaje != 2) {

            try {

                eleccionPersonaje = sc.nextInt();
                entradaValida = true;

            } catch (Exception e) {
                System.out.println("Error: Debes introducir un número entero.");
                sc.nextLine();
            }

        }

        if (eleccionPersonaje == 1) {
            // elegimos a guybrush
            Guybrush guybrush = new Guybrush(InsultArray.getInsults());
            heroi = guybrush;

        } else {
            // elegimos a elaina
            Elaine elaine = new Elaine(InsultArray.getInsults());

            heroi = elaine;
        }

        // metodos visuales
        UI.escribirLento("Nuestro héroe " + heroi.getNom() + " se encuentra con " + illa.getMaxPiratas() + " piratas",
                40);
        UI.pausa(2000);
        UI.limpiarConsola();

        illa.vullPirataActual().sayHello();

        while (!acabarJuego) {

            // Mostramos una UI con las barras de vidas del jugador y pirata
            UI.mostrarUI(heroi.getVida(), 10, illa.vullPirataActual().getNom(),
                    illa.vullPirataActual().getVida(),
                    illa.vullPirataActual().getVidaMax(), heroi.getNom(), illa.getMaxPiratas());

            // obtenemos el string insulto del "pirata actual"

            illa.vullPirataActual().insultar();

            // mostramos las posibles respuestas, elgimos una y la devolvemos
            heroi.defensar();
            respuestaElegida = heroi.elegirRespuesta();
            Sound attackSound = new Sound();
            attackSound.reproducirUnaVez("attack.wav");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }

            // comparamos el string devuelto en defensar() con la respuesta correcta del
            // "pirata actual"
            respuestaEsCorrecta = illa.vullPirataActual().replica(respuestaElegida);

            // metodos visuales
            UI.animarGolpe();
            UI.pausa(1000);
            UI.limpiarConsola();

            // si la respuesta es correcta
            if (respuestaEsCorrecta) {
                // restamos una vida
                if (!illa.vullPirataActual().vida()) {
                    illa.vullPirataActual().sayGoodBye();
                    // si se queda sin vidas, pasamos al siguiente pirata
                    if (illa.nextPirata()) {
                        // si la isla se queda sin piratas, el juego se acaba y hemos ganado
                        acabarJuego = true;
                        // metodo visual
                        Sound finSound = new Sound();
                        finSound.reproducirEnBucle("victory.wav");

                        UI.finDelJuego(true);

                    }
                }
                // si la respuesta es incorrecta
            } else if (!heroi.vida()) {
                // si nos quedamos sin vida, el juego se acaba y hemos perdido
                acabarJuego = true;
                heroi.sayGoodBye();
                // metodo visual
                Sound finSound = new Sound();
                finSound.reproducirEnBucle("game_over.wav");

                UI.finDelJuego(false);

            }
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        // cerramos el scanner
        sc.close();
    }

}
