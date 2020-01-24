package ExercicioEscola;

import ExercicioEscola.OrientacaoObjetos;

public class TesteAluno {
    public static void main(String[] args) {

        OrientacaoObjetos.Alunos testando = new OrientacaoObjetos.Alunos();
        OrientacaoObjetos.Alunos testando2 = new OrientacaoObjetos.Alunos();
        testando.nome = "Rafael";
        testando.rg = "123456";
        testando.dataNascimento = "01/01/1991";

        testando2.nome = "Leopoldo";
        testando2.rg = "76543221";
        testando2.dataNascimento = "02/02/1990";


        System.out.println(testando.nome);
        System.out.println(testando.rg);
        System.out.println(testando.dataNascimento);
        System.out.println(testando2.nome);
        System.out.println(testando2.rg);
        System.out.println(testando2.dataNascimento);

    }
}
