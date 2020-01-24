package ExercicioEscola;

import ExercicioEscola.OrientacaoObjetos;

public class TesteFuncionario {
    public static void main(String[] args) {
        OrientacaoObjetos.Funcionarios funcionario = new OrientacaoObjetos.Funcionarios();

        funcionario.salario = 2000.0;
        funcionario.cargo = "Diretora";

        System.out.println(funcionario.salario);
        System.out.println(funcionario.cargo);
    }

}
