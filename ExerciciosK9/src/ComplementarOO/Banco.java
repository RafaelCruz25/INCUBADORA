package ComplementarOO;

import javax.swing.*;

public class Banco {
    public static int numeroConta;
   public static double limite;
   public static double saldo;

    public void Banco(int numeroConta, double limite){
        this.numeroConta = numeroConta;
        this.limite = limite;
    }

    public void sacar(double valor){
        if(valor > saldo && limite > 0){
            if(valor == (saldo + limite)) {
                saldo -= valor;
                JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso");
            }else{
                JOptionPane.showMessageDialog(null, "Limite indisponivel!");
            }
        }

        else {
            this.saldo -= valor;
        }
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void imprimeExtrato(){
        JOptionPane.showMessageDialog(null,"SALDO: " + this.saldo);
    }


}
