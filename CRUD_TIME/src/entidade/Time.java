package entidade;

import java.io.Serializable;
import java.util.ArrayList;

public class Time implements Serializable {

    private String nomeTime;
    private ArrayList<Membro> arrayMembro;

    public Time(String nomeTime){
        this.nomeTime = nomeTime;
        arrayMembro = new ArrayList<>();
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public ArrayList<Membro> getArrayMembro() {
        return arrayMembro;
    }

    public void setArrayMembro(ArrayList<Membro> arrayMembro) {
        this.arrayMembro = arrayMembro;
    }
}
