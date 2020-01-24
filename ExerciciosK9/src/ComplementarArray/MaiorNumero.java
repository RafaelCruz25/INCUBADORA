package ComplementarArray;

import javax.swing.*;
import java.util.stream.IntStream;

public class MaiorNumero {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        int maior = 0;

        for(int i = 0; i < numeros.length; i++){
            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um numero: "));
        }
        maior = IntStream.of(numeros).max().getAsInt();

        JOptionPane.showMessageDialog(null,"Maior numero: "+ maior);
    }
}
