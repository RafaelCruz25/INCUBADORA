package view.entidades;

import view.utilidades.Arquivo;

public class PessoaTime {

    public static void salvarPessoaTime(String nomeArquivo, String nomePessoa, int opcaoTime, String salvarArquivo){
        String[] parts = Arquivo.gerarLista(nomeArquivo);

        Arquivo.escreverPessoaTime(salvarArquivo, nomePessoa, parts[opcaoTime]);
    }


}
