/*
 * Nicolás Daniel Rueda Araque
 * 42313237e
 * 05/11/2025
 */

package es.cide.programacio;

import java.util.Random;
import java.util.Scanner;


public class Main {
    public static final String[] arrayInsultos = {
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
        "¡Demasiado bobo para mi nivel de inteligencia! ¡ Tengo el coraje y la técnica de un maestro !"
            };

    // creamos una array con cada respuesta
    public static final String[] arrayRespuestas = {
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
            "Estaría acabado si la usases alguna vez."
    };

    private static final int VIDA_JUGADOR = 10;
    private static final int NUM_PIRATES = 3;


    public static void main(String[] args) {
        Random random = new Random();
        //cream el objecte scanner
        Scanner sc = new Scanner(System.in);
        //cream el objecte illa. Illa genera un conjunt aleatori de pirates. Implementat al constructor
        Illa illa = new Illa();
        //variables boolean del joc
        boolean salir = false, guanyar = false;
         //demanam el nom del jugador y cream el objecte heroi amb 10 vides (constant)
        System.out.println("Benvingut a Monkey Island. Introdueix el teu nom: ");

        String heroiNom = sc.nextLine();
        Heroi heroi = new Heroi(heroiNom, VIDA_JUGADOR);

        //bucle por cada pirata
        for(int i = 0; i<NUM_PIRATES; i++){
            //bucle por insultos del pirata (3)
            System.out.println("pirata " + i);
            salir=false;
            for (int j = 0; j < 3; j++) {
                
                while(!salir){
                    System.out.println("insulto " + j);
                    //obtenemos el insulto
                    //respondemos
                    Insult insult1 = illa.vullUnPirata(0).getInsult(0), insult2 = new Insult(), insult3 = new Insult();
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

                    System.out.println(insult1.getInsultText());
                    System.out.println(insult2.getInsultText());
                    System.out.println(insult3.getInsultText());

                    int respuesta = heroi.defensar();
                    //si acertamos
                    if(arrayInsult[respuesta].equals(insultCorrecte)){
                        System.out.println("acierto");
                        if(!illa.vullUnPirata(i).vida()) {
                            System.out.println("el pirata pierde");
                            salir = true;
                    }
                    }
                    else {
                        System.out.println("error");
                        if(!heroi.vida()) {
                            System.out.println("el jugador pierde");
                            salir = true;
                        }
                    }
                }
            }
        }
        sc.close();
    }
}
