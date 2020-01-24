package entidade;

import java.io.Serializable;

public class Membro implements Serializable {

    private String nome;

    public Membro(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
