package es.cide.programacio;

public class LeChuck extends Pirata {

    // ***CONSTRUCOTRES***
    public LeChuck(Insult[] arrIns, int v) {
        // constructor
        super(arrIns, v);
        this.nom = "Pirata LeChuck";
        this.vidaMax = vida;

        // creamos una nueva array de tamaño 4
        Insult[] nuevosInsultos = new Insult[4];

        // igualamos los insultos 1, 2 y 3 del array que se creó en el constructor
        for (int i = 0; i < this.arrayInsults.length; i++) {
            nuevosInsultos[i] = this.arrayInsults[i];
        }

        // el ultimo insulto = al reservado para LeChuck
        nuevosInsultos[3] = arrIns[arrIns.length - 1];
        setArrayInsults(nuevosInsultos);
    }

    // ***METODOS PUBLICOS***
    @Override
    public void sayHello() {
        System.out.println("Saludo desagradable de jefe");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("Despedida desagradable de jefes");
    }

}
