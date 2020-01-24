package ExercicioCartaoCredito;

public class TesteCartaoDeCredito {
    public static void main(String[] args) {
        CartaoDeCredito cdc = new CartaoDeCredito();
        Cliente c = new Cliente();

        c.nome = "Rafael Cruz";
        cdc.numero = 11111;

        cdc.cliente = c;
        System.out.println(cdc.cliente.nome);
        System.out.println(cdc.numero);

    }
}
