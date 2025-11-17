/*
 * Nicolás Daniel Rueda Araque
 * 42313237e
 * 05/11/2025
 */

package es.cide.programacio;

import java.util.Scanner;

public class Main {

    // Colores para el output por consola
    public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MORADO = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";

    // array que contiene objeto de tipo insulto. Cada objeto de tipo insulto
    // contiene su string respuesta y string insulto
    private static final Insult[] arrayInsultos = {

            new Insult("¡Luchas como un granjero! ¡ Ordeñaré hasta la última gota de sangre de tu cuerpo !",
                    "Qué apropiado, tú peleas como una vaca."),
            new Insult(
                    "¡No hay palabras para describir lo asqueroso que eres! Ya no hay técnicas que te puedan salvar.  ",
                    "Sí que las hay, sólo que nunca las has aprendido."),
            new Insult(
                    "¡He hablado con simios más educados que tu! Ahora entiendo lo que significan basura y estupidez.",
                    "Me alegra que asistieras a tu reunión familiar diaria."),
            new Insult(
                    "¡No pienso aguantar tu insolencia aquí sentado! ¡ Eres como un dolor en la parte baja de la espalda !",
                    "Ya te están fastidiando otra vez las almorranas, ¿Eh?"),
            new Insult("¡Mi pañuelo limpiará tu sangre!", "Ah, ¿Ya has obtenido ese trabajo de barrendero?"),
            new Insult("¡Ha llegado tu HORA, palurdo de ocho patas! Hoy te tengo preparada una larga y dura lección.",
                    "Y yo tengo un SALUDO para ti, ¿Te enteras?"),
            new Insult("¿Has dejado ya de usar pañales? Espero que tengas un barco para una rápida huida.",
                    "¿Por qué? ¿Acaso querías pedir uno prestado?"),
            new Insult("¡Una vez tuve un perro más listo que tu! Sólo he conocido a uno tan cobarde como tú.",
                    "Te habrá enseñado todo lo que sabes."),
            new Insult(
                    "¡Nadie me ha sacado sangre jamás, y nadie lo hará! Nunca me verán luchar tan mal como tú lo haces.",
                    "¿TAN rápido corres?"),
            new Insult("¡Me das ganas de vomitar! Si tu hermano es como tú, mejor casarse con un cerdo.",
                    "Me haces pensar que alguien ya lo ha hecho.")
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Illa illa = new Illa(arrayInsultos);
        Heroi heroi;

        boolean acabarJuego = false; // variables boolean
        String heroiNom;

        titulo(illa); // imprimimos el título "The Secret of Monkey Island"

        heroiNom = sc.nextLine(); // pedimos el nombre del jugador y creamos un Heroi con este
        heroi = new Heroi(heroiNom, arrayInsultos);

        escribirLento("Nuestro héroe " + heroi.getNom() + " se encuentra con " + illa.getNumPiratas() + " piratas", 15);
        System.out.println();

        while (!acabarJuego) {
            // Mostramos una UI con las vidas del jugador y pirata
            sprites(heroi.getVida(), 10, illa.vullPirataActual().getNom(), illa.vullPirataActual().getVida(),
                    illa.vullPirataActual().getVidaMax(), heroi.getNom());

            illa.vullPirataActual().insultar(); // mostramos el insulto
            String respuestaElegida = heroi.defensar(); // mostramos las posibles resueltas, eelgimos una y devolvemos
                                                        // el String de este

            boolean respuesta = illa.vullPirataActual().replica(respuestaElegida); // llamamos la funcion replica del
                                                                                   // pirata actual
            limpiarConsola();

            if (respuesta) {
                if (!illa.vullPirataActual().vida())
                    illa.nextPirata();
            } else if (!heroi.vida())
                acabarJuego = true;
        }

        finDelJuego();
        sc.close();
    }

    // **************************************************************************************************************************/
    // Info unicamente visual, no contiene lógica de la práctica

    private static void escribirLento(String texto, int delay) {
        for (char c : texto.toCharArray()) {
            System.out.print(CYAN);
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
            }
        }
        System.out.print(RESET);
    }

    private static String crearBarraDeVida(int actual, int maximo, int longitud) {
        // ... (copiar y pegar de la Opción 1) ...
        actual = Math.max(0, actual);
        double porcentaje = (double) actual / maximo;
        int caracteresLlenos = (int) (porcentaje * longitud);
        int caracteresVacios = longitud - caracteresLlenos;
        String barra = "[" + "█".repeat(caracteresLlenos) + "░".repeat(caracteresVacios) + "]";
        return barra;
    }

    /**
     * Asumo que 'crearBarraDeVida' existe en esta clase.
     */
    /**
     * Genera el panel de batalla como un String[],
     * asegurando que todas las líneas tengan 48 caracteres.
     */
    /**
     * Genera el panel de batalla como un String[],
     * asegurando que todas las líneas tengan 48 caracteres.
     */
    /**
     * Genera el panel de batalla como un String[],
     * asegurando que todas las líneas tengan 48 caracteres.
     */
    private static String[] generarPanelStringArray(int vidaJugador, int maxVidaJugador, String nombrePirata,
            int vidaPirata, int maxVidaPirata, String nombreJugador) {

        int anchoBarra = 20;
        String barraJugador = crearBarraDeVida(vidaJugador, maxVidaJugador, anchoBarra);
        String barraPirata = crearBarraDeVida(vidaPirata, maxVidaPirata, anchoBarra);
        String vidaJugadorStr = vidaJugador + "/" + maxVidaJugador;
        String vidaPirataStr = vidaPirata + "/" + maxVidaPirata;

        // El ancho interno del panel será 44 (total 48)
        String[] panel = new String[11];

        // Creamos las líneas de texto que irán dentro
        String titulo = "        BATALLA DE INSULTOS        ";
        String jugadorInfo = " JUGADOR: " + nombreJugador;
        String jugadorVida = String.format("   Vida: %s %s", barraJugador, vidaJugadorStr);
        String pirataInfo = " PIRATA: " + nombrePirata;
        String pirataVida = String.format("   Vida: %s %s", barraPirata, vidaPirataStr);
        String lineaVacia = "                                            "; // 44 espacios

        // Construimos el panel final usando String.format() para asegurar la longitud
        panel[0] = "╔══════════════════════════════════════════════╗"; // 48 chars
        panel[1] = String.format("║ %-44s ║", titulo);
        panel[2] = "╠══════════════════════════════════════════════╣"; // 48 chars
        panel[3] = String.format("║ %-44s ║", jugadorInfo);
        panel[4] = String.format("║ %-44s ║", jugadorVida);
        panel[5] = String.format("║ %-44s ║", lineaVacia);
        panel[6] = String.format("║ %-44s ║", pirataInfo);
        panel[7] = String.format("║ %-44s ║", pirataVida);
        panel[8] = String.format("║ %-44s ║", lineaVacia);
        panel[9] = String.format("║ %-44s ║", lineaVacia);
        panel[10] = "╚══════════════════════════════════════════════╝"; // 48 chars

        return panel;
    }

    private static void mostrarPanel(int vidaJugador, int maxVidaJugador, String nombrePirata,
            int vidaPirata, int maxVidaPirata, String nombreJugador) {

        // (Asumo que ROJO y RESET son variables de color definidas en tu clase)
        String[] panel = generarPanelStringArray(vidaJugador, maxVidaJugador, nombrePirata, vidaPirata, maxVidaPirata,
                nombreJugador);

        System.out.println(ROJO); // Color encendido
        for (String linea : panel) {
            System.out.println(linea);
        }
        System.out.println(RESET); // Color apagado
        System.out.println(); // El 'println' vacío que tenías
    }

    private static void titulo(Illa i) {
        System.out.print(VERDE);
        System.out.println("\r\n" + //
                "████████╗██╗░░██╗███████╗░░██████╗███████╗░█████╗░██████╗░███████╗████████╗░░█████╗░███████╗\r\n" + //
                "╚══██╔══╝██║░░██║██╔════╝░██╔════╝██╔════╝██╔══██╗██╔══██╗██╔════╝╚══██╔══╝░██╔══██╗██╔════╝\r\n" + //
                "░░░██║░░░███████║█████╗░░░╚█████╗░█████╗░░██║░░╚═╝██████╔╝█████╗░░░░░██║░░░░██║░░██║█████╗░░\r\n" + //
                "░░░██║░░░██╔══██║██╔══╝░░░░╚═══██╗██╔══╝░░██║░░██╗██╔══██╗██╔══╝░░░░░██║░░░░██║░░██║██╔══╝░░\r\n" + //
                "░░░██║░░░██║░░██║███████╗░██████╔╝███████╗╚█████╔╝██║░░██║███████╗░░░██║░░░░╚█████╔╝██║░░░░░\r\n" + //
                "░░░╚═╝░░░╚═╝░░╚═╝╚══════╚░═════╝░╚══════╝░╚════╝░╚═╝░░╚═╝╚══════╝░░░╚═╝░░░░░╚════╝░╚═╝░░░░░\r\n" + //
                "\r\n" + //
                "███╗░░░███╗░█████╗░███╗░░██╗██╗░░██╗███████╗██╗░░░██╗░██╗░██████╗██╗░░░░░░█████╗░███╗░░██╗██████╗░\r\n"
                + //
                "████╗░████║██╔══██╗████╗░██║██║░██╔╝██╔════╝╚██╗░██╔╝░██║██╔════╝██║░░░░░██╔══██╗████╗░██║██╔══██╗\r\n"
                + //
                "██╔████╔██║██║░░██║██╔██╗██║█████═╝░█████╗░░░╚████╔╝░░██║╚█████╗░██║░░░░░███████║██╔██╗██║██║░░██║\r\n"
                + //
                "██║╚██╔╝██║██║░░██║██║╚████║██╔═██╗░██╔══╝░░░░╚██╔╝░░░██║░╚═══██╗██║░░░░░██╔══██║██║╚████║██║░░██║\r\n"
                + //
                "██║░╚═╝░██║╚█████╔╝██║░╚███║██║░╚██╗███████╗░░░██║░░░░██║██████╔╝███████╗██║░░██║██║░╚███║██████╔╝\r\n"
                + //
                "╚═╝░░░░░╚═╝░╚════╝░╚═╝░░╚══╝╚═╝░░╚═╝╚══════╝░░░╚═╝░░░░╚═╝╚═════╝░╚══════╝╚═╝░░╚═╝╚═╝░░╚══╝╚═════╝░");
        System.out.println();
        escribirLento("Bienvenido a " + i.getNom() + ", introduce tu nombre: ", 15);
        System.out.print(RESET);
    }

    private static void finDelJuego() {
        System.out.println(ROJO + "FIN DEL JUEGO");
    }

    private static void limpiarConsola() {
        for (int k = 0; k < 25; k++)
            System.out.println();
    }

    private static void sprites(int vidaJugador, int maxVidaJugador, String nombrePirata,
            int vidaPirata, int maxVidaPirata, String nombreJugador) {

        // --- 'right' CORREGIDO: 66 caracteres de ancho ---
        String[] right = new String[] {
                "                                 ▓▓▓▓▓                                    ",
                "                             ▓▓▓▓▓▓▓▓▓▓▓                                  ",
                "                            ▒▒▒▒█▒▒█▒▒▒▒▒                                 ",
                "                                ▒▒▒▒▒▒▒▒                                  ",
                "                                ▒▒████▒▒▒                                 ",
                "                                 ▓▓▓▓▓▓▓                                  ",
                "                                ▒▒▒▓▓▒▒▒▒▒▒▒                                ",
                "                               ▒░░░▓▓▓▒░░░░░▒                              ",
                "                              ▒░▒▒░▓▓▓▒░░▒▒▒░░▒                            ",
                "                             ▒▒▒ ▒░░▒▒▒▒░▒▒▒▒▒░▒▒                          ",
                "                            ▒▒░░▒ ▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒                          ",
                "                            ▒▒▒▒▒ ▓▓▓▓▓▓▓▓▓▓ ▒▒▒▒▒                          ",
                "                            ▒▒▒▓   ▒▓▓▓▓▒    ▓▒ ▒                          ",
                "                            ▒▓▒▒    ▓▓▓▓▓    ▓▒ ▒                          ",
                "                            ▓▒▓    ▓▓▓▓▓▓▓    ▓▒▒                             ",
                "                            ▓▓     ▓▓▓▓▓▓    ▓▓                             ",
                "                                  ▓▓▓  ▓▓▓                                ",
                "                                 ▓▓▓   ▓▓▓                                ",
                "                                 ▓▓▓     ▓▓                                 ",
                "                                ▓▓▓       ▓▓▓                               ",
                "                                ▒▒▒▒▒   ▒▒▒                                 ",
                "                                ░▒▒▒    ▒▒░                                 ",

        };

        String[] left = new String[] {
                "                               ██▓▓▓▓▓▓██                                       ",
                "                           ██████▓▓▓▓████████                                  ",
                "                         ████▓▓▓▓▓▓███████▓▓███                             ",
                "                         ███████████░░░░░░███████                           ",
                "                         ▓▓█████████▓▓███▓▓██▓▓                          ",
                "                       ███████▓▓  ░░░░░░  ▓▓██▓▓   ██                       ",
                "                       ██  ██░░░░░░░░░░░░▓▓██▓▓ ███                          ",
                "                     ██       ░░░░▓▓██▓▓░░▓▓                                ",
                "                              ██▓▓██████▓▓▓▓██ ",
                "                              ██▓▓░░░░░░████████                            ",
                "                            ████░░▓▓▓▓▓▓░░██████                          ",
                "                      ▓▓▓▓▓▓████░░░░░░░░▓▓████▓▓▓▓▓▓▓▓                   ",
                "                    ▓▓▓▓▓▓▓▓████▓▓░░░░░░▓▓████▓▓▓▓▓▓▓▓▓▓▓▓            ",
                "                  ▓▓▓▓▓▓▓▓▓▓████▓▓▓▓░░▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓      ",
                "                ▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓░░▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓▓▓          ",
                "                ▓▓▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓          ",
                "              ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓██▓▓▓▓▓▓██▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓▓▓     ",
                "              ▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓██▓▓▓▓██▓▓▓▓▓▓██▓▓▓▓▓▓  ▓▓▓▓▓▓▓▓       ",
                "              ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓██▓▓▓▓██▓▓▓▓▓▓  ▓▓▓▓▓▓▓▓      ",
                "              ▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓██████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓       ",
                "              ████▒▒▒▒▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓██████▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒     ",
                "                ██████▓▓▓▓▓▓▓▓██▓▓████████▓▓██▓▓▓▓▓▓▓▓▒▒▒▒████",
                "                ░░░░░░▓▓▓▓▓▓▓▓██  ██    ██  ██▓▓▓▓▓▓▓▓██████   ",
                "                ░░░░░░░░▓▓▓▓▓▓██  ████  ██  ██▓▓▓▓▓▓▓▓░░░░░░",
                "                  ░░░░▓▓▓▓  ▓▓██  ██    ██  ██▓▓▓▓▓▓░░░░░░░░",
                "                    ░░▓▓▓▓▓▓▓▓██░░████████░░██▓▓▓▓▓▓▓▓░░░░░░  ",
                "                      ▓▓▓▓▓▓▓▓██░░░░░░░░░░░░██▓▓▓▓▓▓▓▓░░░░   ",
                "                      ▓▓▓▓▓▓▓▓██░░░░░░░░░░░░████▓▓▓▓▓▓▓▓            ",
                "                      ▓▓▓▓░░▓▓██░░░░░░░░░░░░██▓▓▓▓▓▓▓▓       ",
                "                      ▓▓▓▓░░▓▓██░░░░░░░░░░░░██▓▓▓▓▓▓▓▓          ",
                "                      ▓▓▓▓░░▓▓██░░░░░░░░░░░░██▓▓▓▓░░▓▓    ",
                "                      ▓▓▓▓░░▓▓██░░░░░░  ░░░░░░██▓▓░░██           ",
                "                      ████░░██░░░░░░░░  ░░░░░░░░██░░██     ",
                "                      ████░░██░░░░░░░░  ░░░░░░░░░░░░░░            ",
                "                          ░░░░░░░░░░░░    ░░░░░░░░░░░░            ",
                "                          ▓▓▓▓▓▓▓▓▓▓        ▓▓▓▓▓▓▓▓▓▓▓▓               ",
                "                          ▓▓▓▓▓▓▓▓▓▓▓▓      ▓▓▓▓▓▓▓▓▓▓▓▓            ",
                "                        ██████████▓▓▓▓    ████████████████  ",
                "                        ██████████▓▓▓▓    ████████████████ ",
                "                        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓    ████████████████  ",
                "                            ▓▓▓▓▓▓          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓    ",
                "                            ▓▓████▓▓            ▓▓████▓▓    ",
                "                        ▓▓▓▓████████            ██████████▓▓▓▓  ",
                "                      ▓▓████████████            ██████████████▓▓",

        };

        // Genera el panel (48 caracteres de ancho)
        String[] panel = generarPanelStringArray(vidaJugador, maxVidaJugador, nombrePirata, vidaPirata, maxVidaPirata,
                nombreJugador);

        int maxHeight = 25; // Ambos miden 25
        int panelHeight = panel.length; // 11

        int paddingTop = (maxHeight - panelHeight) / 2; // (25-11)/2 = 7

        // Línea en blanco para el padding (48 espacios)
        String blankPanelLine = "                                                ";

        System.out.println(AMARILLO);

        // Itera e imprime
        // Ahora que los 3 componentes están alineados, la impresión es simple.
        for (int i = 0; i < maxHeight; i++) {

            String leftLine = left[i];
            String rightLine = right[i];
            String panelLine;

            int panelIndex = i - paddingTop;
            if (panelIndex >= 0 && panelIndex < panelHeight) {
                panelLine = panel[panelIndex];
            } else {
                panelLine = blankPanelLine;
            }

            // Imprime las tres columnas alineadas
            System.out.println(leftLine + " " + panelLine + " " + rightLine);
        }

        System.out.println(RESET);
    }
}
