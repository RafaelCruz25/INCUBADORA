package ExercicioCollections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


//NESTE CASO PARA ADICIONAR NO FINAL O ARRAY SE TORNA MELHOR
public class TesteAdicionaFinal {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        long tempo = TesteAdicionaFinal.adicionaFinal(arrayList);
        System.out.println("ArrayList: "+ tempo + "ms");

        tempo = TesteAdicionaFinal.adicionaFinal(linkedList);
        System.out.println("LinkedLista: "+ tempo + "ms");
    }

    public static long adicionaFinal(List lista){
        long inicio = System.currentTimeMillis();

        int size = 100000;

        for(int i = 0; i< size; i++){
            lista.add(i);
        }

        long fim = System.currentTimeMillis();
        return fim - inicio;

    }
}
