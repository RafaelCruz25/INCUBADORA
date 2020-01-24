package ComplementarAtributosMetodos;

public class Teste {
    public static void main(String[] args) {
        System.out.println(Funcionarios.valeRefeicao);
        Funcionarios.valeRefeicao = 15;
        System.out.println(Funcionarios.valeRefeicao);

        Funcionarios.reajustaVale(0.3);
        System.out.println(Funcionarios.valeRefeicao);
    }
}
