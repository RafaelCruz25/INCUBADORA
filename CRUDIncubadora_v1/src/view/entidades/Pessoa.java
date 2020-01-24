package view.entidades;

import view.utilidades.Arquivo;

public class Pessoa {
    String nome;

    public static void adicionarPessoa(String nome, String nomeArquivo){
        Arquivo.gerarArquivo(nomeArquivo, nome);
    }

    public static String gerarListaDePessoas(String nomeArquivo){
        String pessoas = "";
        int i = 0;
        String[] parts = Arquivo.gerarLista(nomeArquivo);

        if(parts.length == 0 || parts == null){
            return "VAZIO";
        }else{
            pessoas += "Pessoas: \n";
            for (String x:Arquivo.gerarLista(nomeArquivo)) {
                pessoas += i + ":  "+ x +"\n";
                i++;
            }
            return pessoas;
        }
    }

    public static void excluirPessoa(String nomeArquivo, int opcaoPessoa){
        String[] parts = Arquivo.gerarLista(nomeArquivo);

        String nomePessoa = parts[opcaoPessoa];

        boolean achou = true;

        for (String x: parts){
            if(x.equals(nomePessoa)){
                achou = true;
                break;
            }
        }

        if(achou){
            parts[opcaoPessoa] = null;
        }

        String sBody = "";

        for (String x: parts) {
            if(x != null) {
                sBody += x + "\n";
            }
        }

        Arquivo.gerarArquivoEditado(nomeArquivo, sBody);

    }

    public static void editarPessoa(String nomeArquivo, int opcaoPessoa, String textoEditar){
        String[] parts = Arquivo.gerarLista(nomeArquivo);

        String nomePessoa = parts[opcaoPessoa];

        boolean achou = true;

        for (String x: parts){
            if(x.equals(nomePessoa)){
                achou = true;
                break;
            }
        }

        if(achou){
            parts[opcaoPessoa] = textoEditar;
        }

        String sBody = "";

        for (String x: parts) {
            sBody += x + "\n";
        }

        Arquivo.gerarArquivoEditado(nomeArquivo, sBody);

    }

    public static String listarPessoa(String nomeArquivo){
        return gerarListaDePessoas(nomeArquivo);
    }
}
