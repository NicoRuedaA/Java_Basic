package es.cide.programacio;

public class LeChuck extends Pirata {

    Insult insultEspecial = new Insult("Insult", "Resposta");

    public LeChuck(Insult[] arrIns, int v) {
        super(arrIns, v);
        this.nom = "LeChuck";
        this.vida *= 2;
        this.vidaMax = vida;
        /*
         * this.arrayInsultos = new Insult[4];
         * generarInsults(arrIns);
         * this.arrayInsultos[3] = insultEspecial;
         */
    }

    @Override
    public void sayHello() {
        System.out.println("Saludo desagradable de jefe");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("Despedida desagradable de jefes");
    }

}
