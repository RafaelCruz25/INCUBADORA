package ComplementarPolimorfismo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ControleDePonto {

    public void registraEntrada(Banco b){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date agora = new Date();

        System.out.println("ENTRADA: "+ b.getCodigo());
        System.out.println("DATA: "+sdf.format(agora));
    }

    public void registraSaida(Banco b){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date agora = new Date();

        System.out.println("SAIDA: "+ b.getCodigo());
        System.out.println("DATA: "+sdf.format(agora));
    }
}
