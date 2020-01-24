package ComplementarOO;

import javax.swing.*;


public class TesteConta {

    public static void main(String[] args) {

        Banco banco = new Banco();
        int opcaoMenu = 0;

        Banco.saldo = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Digite o Saldo da conta: "));
        Banco.limite = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Digite o Limite: "));
        Banco.numeroConta = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Digite o numero da conta: "));

        do {


             opcaoMenu = Integer.parseInt(pegarValores(getMenu()));
            double valor = 0;


            switch (opcaoMenu) {

                case 1:
                   valor = Double.parseDouble(JOptionPane.showInputDialog(null,
                           "Digite o valor do Deposito: "));
                    banco.depositar(valor);
                    break;

                case 2:
                    valor = Double.parseDouble(JOptionPane.showInputDialog(null,
                            "Digite o valor do saque: "));
                    banco.sacar(valor);
                    break;

                case 3:
                    banco.imprimeExtrato();
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null,"Finalizando..");
                    break;

                default:
                    JOptionPane.showMessageDialog(null,"Opcao invalida, digite um numero de 1 a 4!");
                    break;
            }

        } while (opcaoMenu != 4);

    }

    public static String pegarValores (String texto){
        return JOptionPane.showInputDialog(null,texto);
    }

    private static String getMenu(){
        return "MENU: \n"+
                "1- Depositar \n"+
                "2- Sacar \n" +
                "3- Extrato \n"+
                "4- Sair";
    }

}

