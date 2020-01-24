package ContaCorrente;


public class TestaMetodosConta {
    public static void main(String[] args) {

        Agencia a = new Agencia();

        Conta origem = new Conta();
        origem.saldo = 1000;

        Conta destino = new Conta();
        destino.saldo = 1000;

        origem.transfere(destino, 500);

        System.out.println(origem.saldo);
        System.out.println(destino.saldo);
    }
}
