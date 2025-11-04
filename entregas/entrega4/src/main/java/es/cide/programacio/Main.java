package es.cide.programacio;

import java.util.Random;
import java.util.Scanner;


public class Main {

private static final int VIDA_JUGADOR = 10;
private static final int NUM_PIRATES = 3;

    public static void main(String[] args) {
        //cream el objecte scanner
        Scanner sc = new Scanner(System.in);
        //cream el objecte illa. Illa genera un conjunt aleatori de pirates. Implementat al constructor
        Illa illa = new Illa();
        //variables boolean del joc
        boolean salir = false, guanyar = false;

        //demanam el nom del jugador y cream el objecte heroi amb 10 vides (constant)
        String heroiNom = sc.nextLine();
        Heroi heroi = new Heroi(heroiNom, VIDA_JUGADOR);


        int rivalIndex = 0;
        Pirata rival = illa.vullUnPirata(rivalIndex);
        while (!salir) {

            //obtenemos el string de la respuesta
            String resposta = heroi.defensar();
            //pasamos el string de la respuesta
            //si la respuesta es correcta
            if(rival.replica(resposta)){
                //restamos 1 vida
                if(!rival.vida()) {
                    //pasamos al siguiente indice en la array piratas
                    rivalIndex++;
                    //si hemos llegado al ultimo pirata, salimos
                    if(rivalIndex>=NUM_PIRATES) salir=true;
                    //sino pasamos al siguiente pirata
                    else rival = illa.vullUnPirata(rivalIndex);
            }
            //si la respuesta es incorrecta
            else{
                //restamos una vida. SI nos quedamo sin vida, salimos
                if(!heroi.vida()) salir = true;
            }
        }

        sc.close();
    }
}