package es.cide.programacio;

import java.util.Random;

public class Insult {
    private String[] arrayInsultos = {
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
    private String[] arrayRespuestas = {
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

    private Random random = new Random();
    private int insult;

    public Insult(){
        this.insult = random.nextInt(arrayInsultos.length);
    }

    //construcotr para un insulto concreto (posicion en el array)
    public Insult(int x){
        //comprobar
        this.insult = x;
    }

    /*//creamos y devolvemos un insult aleatorio
    public Insult getInsultAleatori(){
        Insult nouInsult = new Insult(random.nextInt(arrayInsultos.length));
        return nouInsult;
    }*/

    public boolean respuestaCorrecta(String s){
        return s.equals(arrayRespuestas[this.insult]);
    }
    

    public String getResposta(int x){
        return arrayRespuestas[x];
    }

    public String getInsultText() {
    return arrayInsultos[this.insult];
}

}
