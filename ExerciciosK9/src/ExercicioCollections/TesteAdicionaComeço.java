package ExercicioCollections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//NESTE CASO PARA ADICIONAR NO COMEÇO O LINKED SE TORNA MAIS VIAVEL
public class TesteAdicionaComeço {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        long tempo = TesteAdicionaComeço.adicionaComeco(arrayList);
        System.out.println("ArrayList: " + tempo + "ms");

        tempo = TesteAdicionaComeço.adicionaComeco(linkedList);
        System.out.println("LinkedLista: "+ tempo + "ms");
    }

    public static long adicionaComeco(List lista){
        long inicio = System.currentTimeMillis();

        int size = 100000;

        for(int i = 0; i< size; i++){
            lista.add(0, i);
        }
        long fim = System.currentTimeMillis();
        return fim - inicio;

    }
}
