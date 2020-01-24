package ExercicioInterface;

public class ContaPoupanca implements Banco {
    private double saldo;

    public void deposita(double valor){
        this.saldo += valor;

    }

    public void saca(double valor){
        this.saldo -= valor;
    }

    public double getSaldo(){
        return this.saldo;
    }
}
