package ComplementarAtributosMetodos;

public class Funcionarios {
    String nome;
    double salario;
    static double valeRefeicao;

    static void reajustaVale(double taxa){
        Funcionarios.valeRefeicao += Funcionarios.valeRefeicao*taxa;
    }
}
