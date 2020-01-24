package ComplementarArray;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {

        int[] numeros = new int[10];
        int soma = 0;
        double media = 0;

        for (int i = 0; i <numeros.length; i++){
            soma += Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um valor: "));
        }

        for (int i= 0; i < numeros.length; i ++){
            media = (soma+i)/numeros.length;
        }
        JOptionPane.showMessageDialog(null, "Media dos valors: "+ media);
    }
}
