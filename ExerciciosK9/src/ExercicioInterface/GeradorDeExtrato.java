package ExercicioInterface;

public class GeradorDeExtrato {

    public void geraExtrato(Banco b){
        System.out.println("EXTRATO");
        System.out.println("SALDO: "+ b.getSaldo());
    }
}
