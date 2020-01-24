package ExerciciosArray;

public class ImprimeArgumentos {
    public static void main(String[] args) {

        String[] nomes = new String[] {"Rafael", "Bruna", "Creonildes"};
        java.util.Arrays.sort(nomes);

        for (String nome: nomes) {
            System.out.println(nome);
        }
    }
}
