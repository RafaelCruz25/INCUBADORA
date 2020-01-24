package ExercicioClasseAbastrata;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaPoupança extends Conta {
    private int diaDoAniversario;

    public int getDiaDoAniversario() {
        return diaDoAniversario;
    }

    public void setDiaDoAniversario(int diaDoAniversario) {
        this.diaDoAniversario = diaDoAniversario;
    }

    public void imprimeExtratoDetalhado(){
        System.out.println("EXTRATO DETALHADO DA CONTA POUPANÇA");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date agora = new Date();

        setDiaDoAniversario(3);

        System.out.println("Data: "+ sdf.format(agora));
        System.out.println("Saldo: "+this.getSaldo());
        System.out.println("Niver: "+this.getDiaDoAniversario());

    }
}
