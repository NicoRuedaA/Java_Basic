package es.cide.programacio;

public class LeChuck extends Pirata {

    Insult insultEspecial = new Insult("Insult", "Resposta");

    public LeChuck(Insult[] arrIns, int v) {
        super(arrIns, "LeChuck", v);
        this.arrayInsultos[2] = insultEspecial;
    }

}
