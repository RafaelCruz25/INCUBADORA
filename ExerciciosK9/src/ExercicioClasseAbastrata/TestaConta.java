package ExercicioClasseAbastrata;

public class TestaConta {
    public static void main(String[] args) {
        Conta c = new ContaPoupança();


        c.setSaldo(1000);
        c.imprimeExtratoDetalhado();
    }
}
