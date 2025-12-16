package es.cide.programacio;

public class LeChuck extends Pirata {

    Insult insultEspecial = new Insult("Insult", "Resposta");

    public LeChuck(Insult[] arrIns, int v) {
        super(arrIns, v);
        this.nom = "Pirata LeChuck";
        this.vidaMax = vida;

        Insult[] nuevosInsultos = new Insult[4];

        for (int i = 0; i < this.arrayInsultos.length; i++) {
            nuevosInsultos[i] = this.arrayInsultos[i];
        }
        nuevosInsultos[3] = insultEspecial;
        this.arrayInsultos = nuevosInsultos;
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
