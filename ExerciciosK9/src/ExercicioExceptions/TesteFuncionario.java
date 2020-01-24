package ExercicioExceptions;

public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario f = new Funcionario();

       // f.aumentaSalario(-1000);

       try {
            f.aumentaSalario(-1000);
        }catch (IllegalArgumentException e){
            System.out.println("Houve um IllegalArgumentException ao aumentar o salario");
        }

    }
}
