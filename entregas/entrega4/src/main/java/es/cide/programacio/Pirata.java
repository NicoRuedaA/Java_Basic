package es.cide.programacio;

import java.util.Random;

public class Pirata {
    private static final int NUM_INSULTS = 3;
    private static final int VIDA_MAX = 3;
    private static final int VIDA_MIN = 1;
    private Random random = new Random();
    private String nom;
    private int vida, vidaMax, insultActual;
    private Insult[] arrayInsultos;

    // un contador para el nombre del pirata
    private int numeroPirata = 1;

    // Constructor
    public Pirata(String[][] arrIns) {
        this.insultActual=0;
        Random random = new Random();
        // le asignamos una vida aleatoria al pirata
        
        this.vida = random.nextInt(VIDA_MIN, VIDA_MAX) + 1;
        this.vidaMax= this.vida;
        this.nom = "Pirata " + numeroPirata;
        numeroPirata++;
        // el nombr del pirata es su ¨numero¨
        
        // creamos un array de Insultos
        this.arrayInsultos = new Insult[NUM_INSULTS];
        
        for (int i = 0; i < arrayInsultos.length; i++) {
            boolean salir = false;
            do {
                
                int aux = random.nextInt(arrIns[0].length);
                if (!Main.estaUsadoElInsulto(aux)) {
                    
                    Main.usarInsulto(aux);
                    
                    salir = true;
                    
                    arrayInsultos[i] = new Insult(aux);
                    
                }
            } while (!salir);
            
            // indicamos que el insulto está usado
        }
    }

    public Pirata(int x, int y, int z) {
        this.insultActual=0;
        // no lo uso en esta version
        this.vida = random.nextInt(VIDA_MIN, VIDA_MAX) + 1;
        numeroPirata++;
        this.nom = "Pirata " + numeroPirata;
        this.arrayInsultos = new Insult[NUM_INSULTS];
        // this.insultActual = 0;
        arrayInsultos[0] = new Insult(x);
        arrayInsultos[1] = new Insult(y);
        arrayInsultos[2] = new Insult(z);
    }

    public Insult insultar() {
        int numRandom = random.nextInt(NUM_INSULTS);
        Insult ins = this.arrayInsultos[numRandom];
        return ins;
    }

    public boolean replica(String s) {
        boolean coincide = arrayInsultos[insultActual].getTextoInsulto().equals(s); 
        this.insultActual++;
        System.out.println(coincide);
        return coincide;
    }

    public boolean vida() {
        boolean vivo = false;
        this.vida--;
        if (vida > 0)  return vivo = true;
        return vivo;
    }

    // GETS Y SETS
    public String getNom() {
        return this.nom;
    }

    public int getVida() {
        return this.vida;
    }

    public int getVidaMax(){
        return this.vidaMax;
    }

    public Insult getInsultoActual() {
        return arrayInsultos[insultActual];
    }

    public Insult getInsulto(int x) {
        return this.arrayInsultos[x];

    }

}
