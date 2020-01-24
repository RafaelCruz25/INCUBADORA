package ComplementarHerança;

public class Telefonistas extends Funcionario{
    private int estacaoDeTrabalho;

    public int getEstacaoDeTrabalho() {
        return estacaoDeTrabalho;
    }

    public void mostrarDados(){
        super.mostrarDados();
        System.out.println("Estação de Trabalho: "+ this.estacaoDeTrabalho);
    }

    public void setEstacaoDeTrabalho(int estacaoDeTrabalho) {
        this.estacaoDeTrabalho = estacaoDeTrabalho;
    }
}
