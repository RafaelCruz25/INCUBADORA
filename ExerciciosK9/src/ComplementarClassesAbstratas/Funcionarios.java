package ComplementarClassesAbstratas;

abstract class Funcionarios {
    private double salario;

    public abstract double calculaBonus();


    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
