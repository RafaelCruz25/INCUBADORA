package ComplementarEncapsulamento;

public class Teste {
    public static void main(String[] args) {

        Banco ban = new Banco();

        ban.setSalario(1000);

        System.out.println(ban.getSalario());
    }
}
