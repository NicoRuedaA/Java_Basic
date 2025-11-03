package es.cide.programacio;

public class Vehiculo {

    String color;
    int plazas;
    int plazasOcupadas;
    int peso;
    // d diesel, g gasolina, e electronico
    char combustible;
    //autonomia total
    int autonomia;
    //consumo de litros/km
    int consumo;
    int litrosTotal;
    int litrosRestantes;

    public void Vehiculo() {
        this.color = " ";
        this.plazas = 0;
        this.peso = 0;
        this.combustible = ' ';
        this.plazasOcupadas = 0;
        this.consumo = 0;
        this.litrosTotal = 0;
        this.litrosRestantes = 0;
    }

    public void Vehiculo(String color, int plazas, int peso, char combustible, int autonomia, int plazasOcupadas, int consumo) {
        this.color = color;
        this.plazas = plazas;
        this.peso = peso;
        this.combustible = combustible;
        this.plazasOcupadas = plazasOcupadas;
        this.consumo = consumo;
        this.litrosTotal =litrosTotal;
        this.litrosRestantes = litrosRestantes;
    }

    //                      **** GET Y SET ****
    public int getPeso() {return this.peso;}

    public String getColor() {return this.color;}
    public void setColor(String a) {this.color = a;}

    public int getPlazas() {return this.plazas;}

    public char getCombustible() {return this.combustible;}

    public int getAutonomia() {return this.autonomia;}

    public int getPlazasOcupadas() {return this.plazasOcupadas;}

    public void setPlazasOcupadas(int x) {this.plazasOcupadas = x;}

    public double getAutonomiaTotal(){
        double rendimiento = 0;
        switch (combustible) {
            case 'g':
            default:
                rendimiento=0.1;
                break;
            case 'd':
                rendimiento=0.2;
                break;
            case 'e':
                rendimiento=0.3;
                break;
            case 'h':
                rendimiento=0.4;
                break;
        }
        return rendimiento*litrosRestantes;
    }
    

}
