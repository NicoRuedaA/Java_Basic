/*
 * Nicolás Daniel Rueda Araque
 * 42313237e
 * 05/11/2025
 */

package es.cide.programacio;

import java.util.Random;
import java.util.Scanner;

public class Main {
    // creamos un array con cada pregunta y su sucesiva respuesta. 
    private static final String[][] arrayInsultos = {
            {"¡Luchas como un granjero! ¡ Ordeñaré hasta la última gota de sangre de tu cuerpo !",
            "¡No hay palabras para describir lo asqueroso que eres! Ya no hay técnicas que te puedan salvar.  ",
            "¡He hablado con simios más educados que tu! Ahora entiendo lo que significan basura y estupidez.",
            "¡No pienso aguantar tu insolencia aquí sentado! ¡ Eres como un dolor en la parte baja de la espalda !",
            "¡Mi pañuelo limpiará tu sangre!",
            "¡Ha llegado tu HORA, palurdo de ocho patas! Hoy te tengo preparada una larga y dura lección.",
            "¿Has dejado ya de usar pañales? Espero que tengas un barco para una rápida huida.",
            "¡Una vez tuve un perro más listo que tu! Sólo he conocido a uno tan cobarde como tú.",
            "¡Nadie me ha sacado sangre jamás, y nadie lo hará! Nunca me verán luchar tan mal como tú lo haces.",
            "¡Me das ganas de vomitar! Si tu hermano es como tú, mejor casarse con un cerdo.",
            "¡Tienes los modales de un mendigo! Cada palabra que sale de tu boca es una estupidez.",
            "¡He oído que eres un soplón despreciable! Mi espada es famosa en todo el Caribe ¡ Mi nombre es temido en cada sucio rincón de esta isla !",
            "¡La gente cae a mis pies al verme llegar! Mis enemigos más sabios corren al verme llegar - Veo gente como tú arrastrándose por el suelo de los bares.",
            "¡Demasiado bobo para mi nivel de inteligencia! ¡ Tengo el coraje y la técnica de un maestro !",
            "¡Eres más lento que una tortuga en melaza!",
            "¡Tu barco huele peor que un barril de peces muertos!",
            "¡Tus palabras son tan afiladas como una cuchara!",
            "¡Tienes menos cerebro que una ostra dormida!",
            "¡Tu espada tiembla más que tus rodillas!",
            "¡Ni los fantasmas quieren asustarte!",
            "¡Peleas como un gallo mareado!",
            "¡Tu tripulación te obedece solo porque no sabe huir!",
            "¡Tu cara haría naufragar a un espejo!",
            "¡Eres la vergüenza de los siete mares!",
            "¡Tu voz suena como un huracán con resaca!",
            "¡Tu honor vale menos que una moneda mordida!",
            "¡Nadie teme a un pirata con olor a ron barato!",
            "¡Si fueras más tonto, te confundirían con el ancla!"},
            {"Qué apropiado, tú peleas como una vaca.",
            "Sí que las hay, sólo que nunca las has aprendido.",
            "Me alegra que asistieras a tu reunión familiar diaria.",
            "Ya te están fastidiando otra vez las almorranas, ¿Eh?",
            "Ah, ¿Ya has obtenido ese trabajo de barrendero?",
            "Y yo tengo un SALUDO para ti, ¿Te enteras?",
            "¿Por qué? ¿Acaso querías pedir uno prestado?",
            "Te habrá enseñado todo lo que sabes.",
            "¿TAN rápido corres?",
            "Me haces pensar que alguien ya lo ha hecho.",
            "Quería asegurarme de que estuvieras a gusto conmigo.",
            "Qué pena me da que nadie haya oído hablar de ti",
            "¿Incluso antes de que huelan tu aliento?",
            "Estaría acabado si la usases alguna vez.",
            "Pues tú eres más espeso que la melaza misma.",
            "Al menos tengo un barco, marinero de remiendo.",
            "Lo suficiente para servirte una derrota.",
            "Y aun así te supero en conversación.",
            "Será del frío que das con tus chistes.",
            "Claro, temen volverse tan aburridos como tú.",
            "¡Y tú cacareas antes de perder!",
            "La tuya huyó antes de aprender a obedecer.",
            "Por eso el tuyo se escondió en el fondo del mar.",
            "¡Y tú, el chiste que los mantiene alegres!",
            "¡Y aún así tiene más ritmo que tus insultos!",
            "¡Entonces tu palabra debe ser de cobre falso!",
            "¡Nadie respeta a uno que lo diluye con agua!",
            "Y tú, con el agujero que hunde el barco."}  };

    private static boolean[] arrayInsultosUsados = new boolean[arrayInsultos[0].length];
    private static final int VIDA_JUGADOR = 10;

    public static boolean estaUsadoElInsulto(int x) {
        return arrayInsultosUsados[x];
    }

    public static void usarInsulto(int x) {
        arrayInsultosUsados[x] = true;
    }

    public static String getText(int x) {
        System.out.println("error aqui");
        System.out.println(arrayInsultos[x].length);
        return arrayInsultos[x][0];
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        Illa illa = new Illa(arrayInsultos);
        // variables boolean
        boolean acabarJuego = false;
        // pedimos el nombre para el usuario
        //System.out.println("Benvingut a Monkey Island. Introdueix el teu nom: ");
        
        System.out.println("      __________     _________   __     __   __   __    _______  _    __\r\n" + //
                        "     / __   __  |   / _____  /  /  |   / /  / /  / /   / _____/ | |  / /\r\n" + //
                        "    / /  | /  | |  / /    / /  / / |  / /  / /_/ /    / /_      | | / /\r\n" + //
                        "   / /  / /  / /  / /    / /  / /| | / /  /    /     /   /      | |/ /\r\n" + //
                        "  / /  / /  / /  / /    / /  / / | |/ /  / /\\ \\     / __/        \\  /\r\n" + //
                        " / /  / /  / /  / /____/ /  / /  | / /  / /  \\ \\   / /_____      / /\r\n" + //
                        "/_/  /_/  /_/  /________/  /_/   |__/  /_/    \\_\\ /_______/     /_/\r\n" + //
                        "\r\n" + //
                        "      __  ______    __          ___     __     __  ____        \r\n" + //
                        "     / / / ___  |  / /         /__ /   /  |   / / / _  |    \r\n" + //
                        "    / / / /_  |_/ / /        / / / /  / / |  / / / / | |        \r\n" + //
                        "   / /  \\__ \\    / /        / /_/ /  / /| | / / / /  / /            \r\n" + //
                        "  / /      | \\  / /       / ____  / / / | |/ / / /  / /            \r\n" + //
                        " / / ______/ / / /_____  / /   / / / /  | / / / /__/ /              \r\n" + //
                        "/_/ /_______/ /_______/ /_/   /_/ /_/   |__/ /______/      \r\n" + //
                        "                                                            ");
        
                        //elegir isla
        System.out.println("Bienvenido a Monkey Island. Introduce tu nombre");

        String heroiNom = sc.nextLine();

        // creamos un protagonista con el nombre
        Heroi heroi = new Heroi(heroiNom, VIDA_JUGADOR);
        
        // bucle por cada pirata
        for (int i = 0; i < illa.getMaxPiratas(); i++) {
            // acabarRonda = false;
            // si el jugador no tiene vidas, obviamos el bucle de insultos
            if (!acabarJuego) {
                // bucle por cada insulto del pirata
                for (int j = 0; j < 3; j++) {
                    while (!acabarJuego) {
                        System.out.println("pirata: " + i + " insulto: " + j);
                        String respuestaElegida = heroi.defensar(arrayInsultos,
                                illa.vullUnPirata(i).getInsultActual());
                        System.out.println("respuesta en main : " + illa.vullUnPirata(i).getNom());
                        //System.out.println("respuesta en main : " + illa.vullUnPirata(i).getInsult(j).getTexto());
                        System.out.println(illa.vullUnPirata(i).getInsult(j).getInsulto());

                        
                        //boolean respuesta = illa.vullUnPirata(i).getInsult(j).getTexto().equals(respuestaElegida);
                        boolean respuesta = illa.vullUnPirata(i).replica(respuestaElegida);
                        if (respuesta) {
                            System.out.println("acierto");
                            if (!illa.vullUnPirata(i).vida()) {
                                System.out.println("el pirata pierde");
                                // acabarRonda = true;
                            }
                            System.out.println("vida pirata: " + illa.vullUnPirata(i).getVida());
                            // si no, el jugador pierde una vida
                        } else {
                            System.out.println("error");
                            if (!heroi.vida()) {
                                System.out.println("el jugador pierde");
                                // si el jugador se queda sin vidas, acabamos el juego.
                                acabarJuego = true;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("FIN DEL JUEGO");
        sc.close();
    }
}
