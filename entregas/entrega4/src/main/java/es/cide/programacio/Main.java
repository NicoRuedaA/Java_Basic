/*
 * Nicolás Daniel Rueda Araque
 * 42313237e
 * 05/11/2025
 */

package es.cide.programacio;

import java.util.Random;
import java.util.Scanner;

public class Main {
    // creamos un array con cada pregunta
    private static final String[] arrayInsultos = {
            "¡Luchas como un granjero! ¡ Ordeñaré hasta la última gota de sangre de tu cuerpo !",
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
            "¡Si fueras más tonto, te confundirían con el ancla!"

    };
    // creamos una array con cada respuesta
    private static final String[] arrayRespuestas = {
            "Qué apropiado, tú peleas como una vaca.",
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
            "Y tú, con el agujero que hunde el barco."
    };
    public static boolean[] arrayInsultosUsados = new boolean[arrayInsultos.length];
    private static final int VIDA_JUGADOR = 10;
    private static final int NUM_PIRATES = 3;

    public static void usarInsulto(int x) {
        if (x > arrayInsultosSize())
            System.out.println("Error. Numero mayor que tamaño de la array");
        arrayInsultosUsados[x] = true;
    }

    public static boolean estaUsadoElInsulto(int x) {
        if (x > arrayInsultosSize()) {
            System.out.println("Error. Numero mayor que tamaño de la array");
            return false;
        }
        return arrayInsultosUsados[x] == true;
    }

    public static int arrayInsultosSize() {
        return arrayInsultos.length;
    }

    public static String getRespuesta(int x) {
        if (x > arrayInsultosSize()) {
            System.out.println("Error. Numero mayor que tamaño de la array");
            return " ";
        }
        return arrayRespuestas[x];
    }

    public static String getInsulto(int x) {
        if (x > arrayInsultosSize()) {
            System.out.println("Error. Numero mayor que tamaño de la array");
            return " ";
        }
        return arrayInsultos[x];
    }

    public static void main(String[] args) {
        System.out.println("Benvingut a Monkey Island. Introdueix el teu nom: ");
        Random random = new Random();
        // cream el objecte scanner
        Scanner sc = new Scanner(System.in);
        // cream el objecte illa. Illa genera un conjunt aleatori de pirates.
        // Implementat al constructor
        Illa illa = new Illa();
        // variables boolean del joc
        boolean acabarRonda = false, acabarJuego = false;
        // demanam el nom del jugador y cream el objecte heroi amb 10 vides (constant)
        System.out.println("Benvingut a Monkey Island. Introdueix el teu nom: ");

        String heroiNom = sc.nextLine();
        Heroi heroi = new Heroi(heroiNom, VIDA_JUGADOR);

        // bucle por cada pirata
        for (int i = 0; i < NUM_PIRATES; i++) {
            acabarRonda = false;
            // si el jugador no tiene vidas, obviamos el bucle de insultos
            if (!acabarJuego) {
                // bucle por cada insulto del pirata
                for (int j = 0; j < 3; j++) {
                    while (!acabarRonda || !acabarJuego) {
                        System.out.println("pirata: " + i);
                        System.out.println("insulto: " + j);
                        // obtenemos el insulto
                        // respondemos
                        Insult insult1 = illa.vullUnPirata(0).getInsult(i), insult2 = new Insult(),
                                insult3 = new Insult();
                        Insult insultCorrecte = insult1;

                        Insult[] arrayInsult = {
                                insult1,
                                insult2,
                                insult3,
                        };

                        // mezclamos el array para imprimirlas por pantalla en un orden aleatorio con
                        // Fisher-Yates
                        for (int k = arrayInsult.length - 1; k > 0; k--) {
                            int l = random.nextInt(k + 1);
                            Insult aux = arrayInsult[k];
                            arrayInsult[k] = arrayInsult[l];
                            arrayInsult[l] = aux;
                        }

                        // usar for. Obtener 3 como constante. Modifica en el for
                        System.out.println(arrayInsult[0].getInsulto());
                        System.out.println(arrayInsult[1].getInsulto());
                        System.out.println(arrayInsult[2].getInsulto());

                        // preguntamos que respuesta queremos
                        int respuesta = heroi.defensar();
                        // guardamos en una varaible el texto de esta respuesta
                        String respuestaString = arrayInsult[respuesta].getInsulto();
                        // si acertamos el pirata pierde una vida
                        // comparamos el texto de la respuesta correcta con el texto de la respuesta
                        // elegida
                        if (respuestaString.equals(insultCorrecte.getInsulto())) {

                            System.out.println("acierto");
                            if (!illa.vullUnPirata(i).vida()) {
                                System.out.println("el pirata pierde");
                                acabarRonda = true;
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
