package ExercicioEscola;

import ExercicioEscola.OrientacaoObjetos;

public class TesteTurma {
    public static void main(String[] args) {
        OrientacaoObjetos.Turma turma = new OrientacaoObjetos.Turma();

        turma.periodo = "Matutino";
        turma.serie = "Quinta-serie";
        turma.sigla = "AB";
        turma.tipoDeEnsino = "EJA";

        System.out.println(turma.periodo);
        System.out.println(turma.serie);
        System.out.println(turma.sigla);
        System.out.println(turma.tipoDeEnsino);
    }
}
