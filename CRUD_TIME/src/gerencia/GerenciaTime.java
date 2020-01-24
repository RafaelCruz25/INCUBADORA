package gerencia;

import entidade.Time;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GerenciaTime {

    private ArrayList<Time> arrayGerenciaTime;

    public GerenciaTime() {
        arrayGerenciaTime = new ArrayList<>();
    }

    public ArrayList<Time> getArrayGerenciaTime() {
        return arrayGerenciaTime;
    }
}
