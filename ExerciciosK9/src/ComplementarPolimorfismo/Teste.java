package ComplementarPolimorfismo;

public class Teste {
    public static void main(String[] args) {

        Gerente g = new Gerente();
        g.setCodigo(123);
        g.setUsuario("Rafael");
        g.setSenha("12345");

        Telefonista t = new Telefonista();
        t.setCodigo(456);
        t.setRamal(13);

        ControleDePonto cdp = new ControleDePonto();

        cdp.registraEntrada(g);
        cdp.registraEntrada(t);

        cdp.registraSaida(g);
        cdp.registraSaida(t);
    }
}
