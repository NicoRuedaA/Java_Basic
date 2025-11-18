package es.cide.programacio;

//clease creada unicamente para separar insultos del Main y hacerlo más legible
public class InsultArray {

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

    public static Insult[] getInsults() {
        return arrayInsultos;
    }

}
