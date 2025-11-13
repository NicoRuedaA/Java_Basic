/*
 * Nicolás Daniel Rueda Araque
 * 42313237e
 * 05/11/2025
 */

package es.cide.programacio;

import java.util.Scanner;

public class Main {
    // creamos un array con cada pregunta y su sucesiva respuesta. 

    public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MORADO = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";

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

    public static String getTextoInsulto(int x) {

        return arrayInsultos[0][x];
    }

        public static String getTextoRespuesta(int x) {

        return arrayInsultos[1][x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Illa illa = new Illa(arrayInsultos);
        Heroi heroi;

        boolean acabarJuego = false;    // variables boolean
        String heroiNom;

        titulo(illa);   //imprimimos el título "The Secret of Monkey Island"   

        heroiNom = sc.nextLine(); //pedimos el nombre del jugador y creamos un Heroi con este
        heroi = new Heroi(heroiNom, VIDA_JUGADOR);

        escribirLento("Nuestro héroe " + heroi.getNom() + " se encuentra con " + illa.getNumPiratas()+ " piratas", 30);
        System.out.println();  

        while(!acabarJuego){
            mostrarPanel(heroi.getVida(), 10, illa.vullPirataActual().getNom(), illa.vullPirataActual().getVida(), illa.vullPirataActual().getVidaMax(), illa.getInsultoActual().getInsulto(), heroi.getNom()); 
            
            System.out.println("el pirata dice : " + illa.getInsultoActual().getTextoInsulto()); System.out.println();

            sprites();

            String respuestaElegida = heroi.defensar(arrayInsultos, illa.getInsultoActual());

            System.out.println("respuesta en main : " + illa.getInsultoActual().getTextoInsulto());

            boolean respuesta = illa.vullPirataActual().replica(respuestaElegida);
            limpiarConsola();

            if (respuesta) {
                if (!illa.vullPirataActual().vida()) illa.nextPirata();
            } 
            else if (!heroi.vida()) acabarJuego = true;
        }        
        
        finDelJuego();
        sc.close();
    }




    private static void escribirLento(String texto, int delay) {
    for (char c : texto.toCharArray()) {
        System.out.print(CYAN);
        System.out.print(c);
        try { Thread.sleep(delay); } catch (InterruptedException e) {}
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

    private static void mostrarPanel(int vidaJugador, int maxVidaJugador, String nombrePirata, 
                                          int vidaPirata, int maxVidaPirata, int numeroInsulto, String nombreJugador) {
        
        int anchoBarra = 20; // Longitud de la barra de vida
        String barraJugador = crearBarraDeVida(vidaJugador, maxVidaJugador, anchoBarra);
        String barraPirata = crearBarraDeVida(vidaPirata, maxVidaPirata, anchoBarra);

        System.out.println(ROJO + "╔════════════════════════════════════╗");
        System.out.println("║         BATALLA DE INSULTOS        ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║  JUGADOR: " + nombreJugador);
        System.out.println("║    Vida: " + barraJugador + " " + vidaJugador + "/" + maxVidaJugador);
        System.out.println("║                                    ║");
        System.out.println("║  PIRATA: " + nombrePirata);
        System.out.println("║    Vida: " + barraPirata + " " + vidaPirata + "/" + maxVidaPirata);
        System.out.println("║                                    ║");
        System.out.println("║  Insulto Actual: #" + numeroInsulto );
        System.out.println("╚════════════════════════════════════╝" + RESET);
        System.out.println();

        
    }

    private static void titulo(Illa i){
        System.out.println("\r\n" + //
                                "████████╗██╗░░██╗███████╗░░██████╗███████╗░█████╗░██████╗░███████╗████████╗░░█████╗░███████╗\r\n" + //
                                "╚══██╔══╝██║░░██║██╔════╝░██╔════╝██╔════╝██╔══██╗██╔══██╗██╔════╝╚══██╔══╝░██╔══██╗██╔════╝\r\n" + //
                                "░░░██║░░░███████║█████╗░░░╚█████╗░█████╗░░██║░░╚═╝██████╔╝█████╗░░░░░██║░░░░██║░░██║█████╗░░\r\n" + //
                                "░░░██║░░░██╔══██║██╔══╝░░░░╚═══██╗██╔══╝░░██║░░██╗██╔══██╗██╔══╝░░░░░██║░░░░██║░░██║██╔══╝░░\r\n" + //
                                "░░░██║░░░██║░░██║███████╗░██████╔╝███████╗╚█████╔╝██║░░██║███████╗░░░██║░░░░╚█████╔╝██║░░░░░\r\n" + //
                                "░░░╚═╝░░░╚═╝░░╚═╝╚══════╚░═════╝░╚══════╝░╚════╝░╚═╝░░╚═╝╚══════╝░░░╚═╝░░░░░╚════╝░╚═╝░░░░░\r\n" + //
                                "\r\n" + //
                                "███╗░░░███╗░█████╗░███╗░░██╗██╗░░██╗███████╗██╗░░░██╗░██╗░██████╗██╗░░░░░░█████╗░███╗░░██╗██████╗░\r\n" + //
                                "████╗░████║██╔══██╗████╗░██║██║░██╔╝██╔════╝╚██╗░██╔╝░██║██╔════╝██║░░░░░██╔══██╗████╗░██║██╔══██╗\r\n" + //
                                "██╔████╔██║██║░░██║██╔██╗██║█████═╝░█████╗░░░╚████╔╝░░██║╚█████╗░██║░░░░░███████║██╔██╗██║██║░░██║\r\n" + //
                                "██║╚██╔╝██║██║░░██║██║╚████║██╔═██╗░██╔══╝░░░░╚██╔╝░░░██║░╚═══██╗██║░░░░░██╔══██║██║╚████║██║░░██║\r\n" + //
                                "██║░╚═╝░██║╚█████╔╝██║░╚███║██║░╚██╗███████╗░░░██║░░░░██║██████╔╝███████╗██║░░██║██║░╚███║██████╔╝\r\n" + //
                                "╚═╝░░░░░╚═╝░╚════╝░╚═╝░░╚══╝╚═╝░░╚═╝╚══════╝░░░╚═╝░░░░╚═╝╚═════╝░╚══════╝╚═╝░░╚═╝╚═╝░░╚══╝╚═════╝░");
    System.out.println();
    escribirLento("Bienvenido a " + i.getNom() + ", introduce tu nombre: ", 30);
                            
}

private static void finDelJuego(){
    System.out.println(ROJO + "FIN DEL JUEGO");
}

private static void limpiarConsola(){
    for (int k = 0; k <25; k++) System.out.println();
}


private static void sprites(){
    System.out.println("       /   \\  \r\n" + //
                " (·.·)/     \\(·.·)\r\n" + //
                " <) )        ( (<\r\n" + //
                " / \\         / \\");
}
}
