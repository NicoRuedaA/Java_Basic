package es.cide.programacio;

import java.util.Random;

public class Guybrush extends Heroi {

    // vida (inicial) constante
    private static final int VIDA_INICIAL = 12;

    // ***CONSTRUCTORES***
    public Guybrush(Insult[] arrResp) {
        super("Guybrush", VIDA_INICIAL, arrResp);
        sayHello();
    }

    @Override
    public void sayHello() {
        String saludo = UI.VERDE + " \"¡Ajá! ¡Sabía que tenías buen gusto! Soy Guybrush Threepwood, ¡Poderoso Pirata!\n"
                + //
                "\n" + //
                "Prepárate, porque esta vez voy en serio. Tengo un abrigo de cuero, tengo un mapa (creo) y, lo más importante... mira esto: *se señala la cara* ¡Tengo barba! Bueno, es una pelusilla muy masculina, pero cuenta.\n"
                + //
                "\n" + //
                "¡Vamos a encontrar el Big Whoop antes de que LeChuck vuelva a fastidiarlo todo!\"";
        UI.escribirLento(saludo, 7);
        UI.pausa(1000);
        System.out.println();
    }

    @Override
    public void sayGoodBye() {
        System.out.println("Despedida informal");
    }

    @Override
    public void defensar() {

        UI.escribirLento(" ¿Qué le contestas? (1-10)", 15);
        System.out.println();
        // mostramos las respuestas

        Random random = new Random();
        int x = random.nextInt(2);
        if (x == 1) {
            // mostramos la primera mitad de las respuestas
            for (int i = 0; i < arrayRespuestas.length / 2; i++) {
                UI.escribirLento((i + 1) + " " + arrayRespuestas[i].getTextoRespuesta(), 5);
                System.out.println();
            }
        }

        else {
            // mostramos la segunda mitade las respuestas
            for (int i = arrayRespuestas.length / 2; i < arrayRespuestas.length; i++) {
                UI.escribirLento((i + 1) + " " + arrayRespuestas[i].getTextoRespuesta(), 5);
                System.out.println();
            }
        }

    }

    // ***METODOS CON RETURNs***
    @Override
    public boolean vida() {
        this.vida -= 2;
        return vida > 0;
    }

}
