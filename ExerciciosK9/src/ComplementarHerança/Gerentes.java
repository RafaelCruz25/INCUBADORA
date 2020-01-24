package ComplementarHerança;

public class Gerentes extends Funcionario{
    private String usuario;
    private String senha;

    public double calculaBonificacao(){
        return this.getSalario() * 0.6 + 100;
    }

    public void mostrarDados(){
        super.mostrarDados();
        System.out.println("Usuario: "+ this.usuario);
        System.out.println("Senha: "+ this.senha);
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
