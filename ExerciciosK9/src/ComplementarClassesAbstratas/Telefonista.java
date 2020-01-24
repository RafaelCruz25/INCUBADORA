package ComplementarClassesAbstratas;

public class Telefonista extends Funcionarios {
    private String usuario;
    private String senha;

    public double calculaBonus(){
        return this.getSalario()* 0.2 + 300;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
