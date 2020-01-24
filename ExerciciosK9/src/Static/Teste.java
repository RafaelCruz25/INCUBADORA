package Static;

public class Teste {
    public static void main(String[] args) {
        System.out.println("Contador: " + Conta.contador);

        Conta c1 = new Conta();
        System.out.println("Numero primeira conta: " + c1.numero);

        Conta c2 = new Conta();
        System.out.println("Numero segunda conta: " + c2.numero);

        System.out.println("Contador: " + Conta.contador);

        Conta.zeraContador();
    }
}
