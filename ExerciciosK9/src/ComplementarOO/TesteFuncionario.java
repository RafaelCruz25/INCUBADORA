package ComplementarOO;

import javax.swing.*;

public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario fun = new Funcionario(200);

       fun.nome = String.valueOf(JOptionPane.showInputDialog("Digite o nome do funcionario: "));

       int opcaoMenu = 0;

       do{
           opcaoMenu = Integer.parseInt(pegarValores(getMenu()));
           double valor = 0;
           String nomeModificado;

           switch (opcaoMenu){
               case 1:
                   valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do aumento: "));
                   double aumentar = valor;
                   if(aumentar < 0){
                       JOptionPane.showMessageDialog(null,"Digita valores positivos!");
                   }
                   else{
                       fun.salario += aumentar;
                       JOptionPane.showMessageDialog(null,"Aumento realizado com sucesso");
                   }
                   break;

               case 2:
                   JOptionPane.showMessageDialog(null, "Nome atual: "+ fun.nome);
                   nomeModificado = JOptionPane.showInputDialog(null,"Digite o novo nome: ");
                   fun.nome = nomeModificado;
                   break;

               case 3:
                   JOptionPane.showMessageDialog(null
                           ,"DADOS DO FUNCIONARIO \n"+ "Nome: "+ fun.nome + " \nSalário: "+ fun.salario) ;

                   break;

               case 4:
                    JOptionPane.showMessageDialog(null,"Finalizando..");
                    break;

               default:
                   JOptionPane.showMessageDialog(null,"Opcao invalida, digite um numero de 1 a 4!");
                   break;
           }
       }while(opcaoMenu != 4);

    }

    public static String pegarValores (String texto){
        return JOptionPane.showInputDialog(null,texto);
    }

    private static String getMenu(){
        return "MENU: \n"+
                "1- Aumentar Salario \n"+
                "2- Corrigir Nome Funcionario \n" +
                "3- Imprimir dados \n"+
                "4- Sair";
    }
}
