/*
 * Nicolás Daniel Rueda Araque
 * 42313237e
 * 05/11/2025
 */
package es.cide.programacio;

import java.util.Random;

//objeto pirata
public class Pirata extends Personatge {
    // constantes para crear el pirata
    private static final int NUM_INSULTS = 3;

    private Insult insultActual;
    // array de Insultos que almacenará 3 insultos aleatorios. No se pueden repetir.
    // Se pueden repetir entre piratas
    protected Insult[] arrayInsultos;
    // un contador estatico para el nombre del pirata. Va sumando 1 con cada
    // creación de pirata
    private static int numeroPirata = 1;

    private static int vidaMax;
    /*
     * // Constructor. Le pasamos un array de insultos
     * public Pirata(Insult[] arrIns) {
     * super("", 0);
     * Random random = new Random();
     * // Le asignamos una vida aleatoria al pirata
     * // Le asignamos su vida como vida maxima (uso para barra gráfica)
     * this.vida = random.nextInt(VIDA_MIN, VIDA_MAX + 1);
     * this.vidaMax = this.vida;
     * // declaramos el nombre del pirata según su numero
     * this.nom = "Pirata " + numeroPirata;
     * numeroPirata++;
     * // creamos un array de Insultos
     * generarInsults(arrIns);
     * }
     */

    public Pirata(Insult[] arrIns, String n, int v) {
        super(n, v);
        this.vidaMax = this.vida;
        // creamos un array de Insultoss

        generarInsults(arrIns);
    }

    private void generarInsults(Insult[] arrIns) {
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
        this.insultActual = arrayInsultos[random.nextInt(NUM_INSULTS)];
        // imprimimos el resultado
        if (coincide)
            UI.escribirLento("RESPUESTA CORRECTA", 50);
        else
            UI.escribirLento("RESPUESTA INCORRECTA", 50);
        System.out.println();
        // devolvemos el resultado
        return coincide;
    }

    // devolvemos el int de la variable "vidaMax"
    public int getVidaMax() {
        return this.vidaMax;
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

    }

    public void sayGoodBye() {

    }

    public void defensar() {

    }

    // devolvemos el String del "insulto actual"
    public void insultar() {
        // imprimimos el nombre del pirata actual y el String "insulto"
        UI.escribirLento(this.getNom() + ": " + this.insultActual, 15);
    }

    @Override
    public boolean vida() {
        this.vida--;
        return vida > 0;
    }

    public String getNom() {
        return this.nom;
    }

}
