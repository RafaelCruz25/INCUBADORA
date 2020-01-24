package ExercicioEncapsulamento;

public class Teste {
    public static void main(String[] args) {
        Funcionarios fun = new Funcionarios();

        fun.setNome("Rafael Cruz");
        fun.setSalario(2000);

        System.out.println(fun.getNome());
        System.out.println(fun.getSalario());
    }
}
