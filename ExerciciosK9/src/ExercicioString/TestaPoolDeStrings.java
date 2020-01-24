package ExercicioString;

public class TestaPoolDeStrings {
    public static void main(String[] args) {
        String nome1 = "Rafael Cruz";
        String nome2 = "Rafael Cruz";

        System.out.println(nome1 == nome2);
        System.out.println(nome1.equals(nome2));

        String nome3 = new String("Rafael Cruz");
        String nome4 = new String("Rafael Cruz");

        System.out.println(nome3 == nome4);
        System.out.println(nome3.equals(nome4));
    }
}
