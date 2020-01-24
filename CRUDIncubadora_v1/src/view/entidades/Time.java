package view.entidades;

import view.utilidades.Arquivo;

import java.util.ArrayList;

public class Time {

    public static void adicionarTime(String nome, String nomeArquivo){
        Arquivo.gerarArquivo(nomeArquivo, nome);
    }

    public static String gerarListaDeTimes(String nomeArquivo){
        String times = "";
        int i = 0;
        String[] parts = Arquivo.gerarLista(nomeArquivo);

        if(parts.length == 0 || parts == null){
            return "VAZIO";
        }else{
            times += "Times: \n";
            for (String x:Arquivo.gerarLista(nomeArquivo)) {
                times += i + ":  "+ x +"\n";
                i++;
            }
            return times;
        }
    }

    public static void excluirTime(String nomeArquivo, int opcaoTime){
        String[] parts = Arquivo.gerarLista(nomeArquivo);

        String nomeTime = parts[opcaoTime];

        boolean achou = true;

        for (String x: parts){
            if(x.equals(nomeTime)){
               achou = true;
                break;
            }
        }

        if(achou){
            parts[opcaoTime] = null;
        }

        String sBody = "";

        for (String x: parts) {
            if(x != null) {
                sBody += x + "\n";
            }
        }

        Arquivo.gerarArquivoEditado(nomeArquivo, sBody);

    }

    public static void editarTime(String nomeArquivo, int opcaoTime, String textoEditar){
        String[] parts = Arquivo.gerarLista(nomeArquivo);

        String nomeTime = parts[opcaoTime];

        boolean achou = true;

        for (String x: parts){
            if(x.equals(nomeTime)){
                achou = true;
                break;
            }
        }

        if(achou){
            parts[opcaoTime] = textoEditar;
        }

        String sBody = "";

        for (String x: parts) {
            sBody += x + "\n";
        }

        Arquivo.gerarArquivoEditado(nomeArquivo, sBody);

    }

    public static String listarTime(String nomeArquivo){
        return gerarListaDeTimes(nomeArquivo);
    }
}
