package ExerciciosHerança;

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

        System.out.println("\nGERENTE");
        System.out.println("Nome: "+ g.getNome());
        System.out.println("Salario: "+ g.getSalario());
        System.out.println("Usuario: "+ g.getUsuario());
        System.out.println("Senha: "+ g.getSenha());
        System.out.println("Bonificacao: "+ g.calculaBonificacao());

        System.out.println("\nTELEFONISTA");
        System.out.println("Nome: "+ t.getNome());
        System.out.println("Salario: "+ t.getSalario());
        System.out.println("Estacao de trabalho: "+ t.getEstacaoDeTrabalho());
        System.out.println("Bonificacao: "+t.calculaBonificacao());

        System.out.println("\nSECRETARIA");
        System.out.println("Nome: "+ s.getNome());
        System.out.println("Salario: "+ s.getSalario());
        System.out.println("Ramal: "+s.getRamal());
        System.out.println("Bonificacao: "+ s.calculaBonificacao());
    }
}
