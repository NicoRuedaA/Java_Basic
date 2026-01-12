/*
 * Nicolás Daniel Rueda Araque
 * 42313237e
 * 05/11/2025
 */

package es.cide.programacio;

import java.util.Scanner;

public class Main {

    private static void limpiarConsola(int x) {
        // funcion para no repetir codigo
        UI.pausa(x);
        UI.limpiarConsola();
    }

    private static void pausarCodigo(int x) {
        // pausar el codigo para evitar que el sonido que se reproduce no se
        // desincronice con la parte visual
        // miramos si hay algun error al ejecutarlo. Puede darse al ejecutarse otro
        // proceso
        try {
            // para el hilo x milisegundos
            Thread.sleep(x);
        } catch (InterruptedException e) {
            // caso de error
            e.printStackTrace();

        }
    }

    private static int elegirPersonaje(Scanner sc) {
        boolean entradaValida = false;
        int eleccion = 100;
        // mientras que la entrada no sea int o el numero no esté en el rango repetimos
        // la petición
        while (!entradaValida || eleccion != 1 && eleccion != 2) {

            try {

                eleccion = sc.nextInt();
                entradaValida = true;

            } catch (Exception e) {
                System.out.println("Error: Debes introducir un número entero.");
                sc.nextLine();
            }

        }

        return eleccion;

    }

    private static void gameOver() {
        // metodo visual
        Sound finSound = new Sound();
        finSound.reproducirEnBucle("game_over.wav");
        UI.imprimirLeChuck();
        UI.finDelJuego(false);
    }

    private static void victory() {
        // metodo visual
        Sound finSound = new Sound();
        finSound.reproducirEnBucle("victory.wav");

        UI.finDelJuego(true);

    }

    private static void mostrarUI(Heroi heroi, Illa illa) {
        UI.mostrarUI(heroi.getVida(), heroi.getVidaMax(), illa.vullPirataActual().getNom(),
                illa.vullPirataActual().getVida(),
                illa.vullPirataActual().getVidaMax(), heroi.getNom(), illa.getMaxPiratas());

    }

    private static void reproducirUnaVez(String s) {
        Sound attackSound = new Sound();
        attackSound.reproducirUnaVez(s);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // abrimos el scanner

        Illa illa = new Illa(InsultArray.getInsults());// creamos la isla pasandole nuestra array estatica de objetos
                                                       // "insult"
        boolean respuestaEsCorrecta, acabarJuego = false; // variables para interactuar durante
                                                          // el juego
        String respuestaElegida;

        // imprimimos el título
        UI.titulo(illa);

        // creamos un heroe (vacío)
        Heroi heroi;

        // eleccion del personaje
        int eleccionPersonaje = elegirPersonaje(sc);

        // si la eleccion es 1 el hereoe será Guybrush. Sino Elaine
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
        limpiarConsola(2000);

        illa.vullPirataActual().sayHello();

        while (!acabarJuego) {

            // Mostramos una UI con las barras de vidas del jugador y pirata
            mostrarUI(heroi, illa);

            // obtenemos el string insulto del "pirata actual"
            illa.vullPirataActual().insultar();

            // mostramos las posibles respuestas, elgimos una y la devolvemos
            heroi.defensar();
            respuestaElegida = heroi.elegirRespuesta();

            // metodo unicamente de sonido
            reproducirUnaVez("attack.wav");
            pausarCodigo(100);

            // comparamos el string devuelto en defensar() con la respuesta correcta del
            // "pirata actual"
            respuestaEsCorrecta = illa.vullPirataActual().replica(respuestaElegida);

            // metodos visuales
            UI.animarGolpe();
            limpiarConsola(2000);
            // si la respuesta es correcta
            if (respuestaEsCorrecta) {
                // restamos una vida

                if (!illa.vullPirataActual().vida()) {
                    illa.vullPirataActual().sayGoodBye();
                    // si se queda sin vidas, pasamos al siguiente pirata
                    if (illa.nextPirata()) {
                        // si la isla se queda sin piratas, el juego se acaba y hemos ganado
                        acabarJuego = true;
                        victory();
                    }
                }
                // si la respuesta es incorrecta
            } else {
                /*
                 * // si el heroe es Guybrush
                 * if (heroi instanceof Guybrush)
                 * // le quitamos una vida extra
                 * heroi.vida();
                 */
                if (!heroi.vida()) {
                    // si nos quedamos sin vida, el juego se acaba y hemos perdido
                    acabarJuego = true;
                    heroi.sayGoodBye();
                    gameOver();
                }
            }

        }

        pausarCodigo(3000);
        // cerramos el scanner
        sc.close();
    }

}
