package ComplementarHerança;

public class Teste {
    public static void main(String[] args) {
        Gerentes g = new Gerentes();
        g.setNome("Rafael Cruz");
        g.setSalario(2000);
        g.setUsuario("rafacruz");
        g.setSenha("12345");

        Telefonistas t = new Telefonistas();
        t.setNome("Bruna");
        t.setSalario(1500);
        t.setEstacaoDeTrabalho(13);

        Secretarias s = new Secretarias();
        s.setNome("Baiana");
        s.setSalario(1500);
        s.setRamal(198);

        System.out.println("GERENTE");
        g.mostrarDados();

        System.out.println("\nTELEFONISTA");
        t.mostrarDados();

        System.out.println("\nSECRETARIA");
        s.mostrarDados();

    }
}
