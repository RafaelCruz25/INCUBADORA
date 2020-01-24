package ComplementarHerança;

public class Secretarias extends Funcionario {
    private int ramal;

    public void mostrarDados(){
        super.mostrarDados();
        System.out.println("Ramal: "+ this.ramal);
    }

    public int getRamal() {
        return ramal;
    }

    public void setRamal(int ramal) {
        this.ramal = ramal;
    }
}
