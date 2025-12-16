/*
 * Nicolás Daniel Rueda Araque
 * 42313237e
 * 05/11/2025
 */
package es.cide.programacio;

import java.util.Random;

//objeto pirata
public class Pirata extends Personatge implements Speak, Fight {
    // constantes para crear el pirata
    private static final int NUM_INSULTS = 3;

    private Insult insultActual;
    // array de Insultos que almacenará 3 insultos aleatorios. No se pueden repetir.
    // Se pueden repetir entre piratas
    protected Insult[] arrayInsultos;
    // un contador estatico para el nombre del pirata. Va sumando 1 con cada
    // creación de pirata
    private static int numeroPirata = 1;

    protected int vidaMax;

    public Pirata(Insult[] arrIns, int n) {
        super("", n);
        Random random = new Random();
        // Le asignamos una vida aleatoria al pirata
        // Le asignamos su vida como vida maxima (uso para barra gráfica)
        this.vidaMax = this.vida;
        // declaramos el nombre del pirata según su numero
        this.nom = "Pirata " + numeroPirata;
        numeroPirata++;
        // creamos un array de Insultos
        this.arrayInsultos = new Insult[NUM_INSULTS];

        // creamos 3 int aleatorios para obtener 3 insultos aleatorios del array pasado
        int x, y, z;
        // x es un random entre el tamaño del array y 0
        x = random.nextInt(arrIns.length);
        // lo mismo con y pero sin que sea igual a x
        do {
            y = random.nextInt(arrIns.length);
        } while (y == x);
        // lo mismo con z pero sin que sea igual a x e y
        do {
            z = random.nextInt(arrIns.length);
        } while ((z == x) || (z == y));

        // insertamos los insultos en la lista
        arrayInsultos[0] = arrIns[x];
        arrayInsultos[1] = arrIns[y];
        arrayInsultos[2] = arrIns[z];

        // le asignamos uno de los insultos creados como "insulto actual"
        this.insultActual = arrayInsultos[random.nextInt(NUM_INSULTS)];

    }

    protected void generarInsults(Insult[] arrIns) {
        Random random = new Random();
        this.arrayInsultos = new Insult[NUM_INSULTS];
        // creamos 3 int aleatorios para obtener 3 insultos aleatorios del array pasado
        int x, y, z;
        // x es un random entre el tamaño del array y 0
        x = random.nextInt(arrIns.length);
        // lo mismo con y pero sin que sea igual a x
        do {
            y = random.nextInt(arrIns.length);
        } while (y == x);
        // lo mismo con z pero sin que sea igual a x e y
        do {
            z = random.nextInt(arrIns.length);
        } while ((z == x) || (z == y));

        // insertamos los insultos en la lista
        this.arrayInsultos[0] = arrIns[x];
        this.arrayInsultos[1] = arrIns[y];
        this.arrayInsultos[2] = arrIns[z];
        this.insultActual = arrayInsultos[random.nextInt(NUM_INSULTS)];

    }

    // devolvemos false o true según la comparación entre el String pasado "s" y la
    // respuesta de nuestro insulto actual
    public boolean replica(String s) {

        // comparamos el string pasado conla respuesta del insulto actual
        boolean coincide = insultActual.getTextoRespuesta().equals(s);
        // actualizamos el insulto actual
        Random random = new Random();
        this.insultActual = arrayInsultos[random.nextInt(arrayInsultos.length)];
        // imprimimos el resultado
        if (coincide)
            UI.escribirLento("RESPUESTA CORRECTA", 50);
        else
            UI.escribirLento("RESPUESTA INCORRECTA", 50);
        System.out.println();
        // devolvemos el resultado
        return coincide;
    }

    // devolvemos el objeto tipo Insult del "Insult actual"
    public Insult getInsultoActual() {
        return insultActual;
    }

    // devolvemos un objeto insulto concreto por índice X
    public Insult getInsulto(int x) {
        if (x >= NUM_INSULTS) {
            UI.escribirLento("X fuera de rango", 10);
            return this.arrayInsultos[0];
        }
        return this.arrayInsultos[x];

    }

    public void sayHello() {
        System.out.println("Saludo desagradable");
    }

    public void sayGoodBye() {
        System.out.println("Despedida desagradable");
    }

    public void defensar() {

    }

    // devolvemos el String del "insulto actual"
    public void insultar() {
        // imprimimos el nombre del pirata actual y el String "insulto"
        UI.escribirLento(this.getNom() + ": " + this.insultActual.getTextoInsulto(), 15);
        Sound insult = new Sound();

        insult.reproducirUnaVez("pirate.wav");

    }

    @Override
    public boolean vida() {
        this.vida--;
        return vida > 0;
    }

    public int getVida() {
        return this.vida;
    }

    public String getNom() {
        return this.nom;
    }

    // devolvemos el int de la variable "vidaMax"
    public int getVidaMax() {
        return this.vidaMax;
    }

}
