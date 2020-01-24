package ComplementarClassesAbstratas;



public class TesteConta {
    public static void main(String[] args) {

       // Funcionarios f = new Funcionarios(); // quando está abstrata não pode estanciar a classe.

        Funcionarios f = new Telefonista();

        f.setSalario(3000);

        System.out.println(f.getSalario());
        System.out.println(f.calculaBonus());
    }
}
