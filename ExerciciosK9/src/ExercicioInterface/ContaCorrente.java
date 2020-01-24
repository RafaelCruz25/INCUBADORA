package ExercicioInterface;

public class ContaCorrente implements Banco {
    private double saldo;
    private double taxaPorOperacao = 0.45;


    public void deposita(double valor) {
        this.saldo += valor - this.taxaPorOperacao;
    }

    public void saca(double valor){
        this.saldo -= valor + this.taxaPorOperacao;
    }

    public double getSaldo(){
        return this.saldo;
    }
}
