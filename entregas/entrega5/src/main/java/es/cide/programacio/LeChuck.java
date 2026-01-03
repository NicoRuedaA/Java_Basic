package es.cide.programacio;

public class LeChuck extends Pirata {

    public LeChuck(Insult[] arrIns, int v) {
        super(arrIns, v);
        this.nom = "Pirata LeChuck";
        this.vidaMax = vida;

        Insult[] nuevosInsultos = new Insult[4];

        for (int i = 0; i < this.arrayInsults.length; i++) {
            nuevosInsultos[i] = this.arrayInsults[i];
        }

        // el ultimo insulto esta reservado para LeChuck
        nuevosInsultos[3] = arrIns[arrIns.length - 1];
        setArrayInsults(nuevosInsultos);
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
