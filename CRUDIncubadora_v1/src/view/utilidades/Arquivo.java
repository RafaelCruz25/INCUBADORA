package view.utilidades;

import java.io.*;

public class Arquivo {

    public static String lerArquivo(String rFilename) {
        File file = new File("Arquivos", rFilename);
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            int i = 0;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        } catch (IOException e) {
            // exibir erro caso não funcione
        }
        return text.toString();
    }

    public static void gerarArquivo(String sFileName, String sBody) {
        try {
            File root = new File("Arquivos");

            if (!root.exists()) {
                root.mkdirs();
            }

            File gpxfile = new File(root, sFileName);
            StringBuilder conteudo = new StringBuilder();

            if (gpxfile.exists()) {
                String conteudoExistente = lerArquivo(sFileName);
                conteudo.append(conteudoExistente);
            }

            conteudo.append(sBody);
            conteudo.append('\n');

            FileWriter writer = new FileWriter(gpxfile);
            writer.append(conteudo.toString());
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void gerarArquivoEditado(String sFileName, String sBody){
        try {
            File root = new File("Arquivos");

            if (!root.exists()) {
                root.mkdirs();
            }

            File gpxfile = new File(root, sFileName);
            StringBuilder conteudo = new StringBuilder();

            conteudo.append(sBody);
            conteudo.append('\n');

            FileWriter writer = new FileWriter(gpxfile);
            writer.append(conteudo.toString());
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] gerarLista(String rFilename){

        String texto = lerArquivo(rFilename);
        String[] parts = texto.split("\n");

        return parts;
    }

    public static void escreverPessoaTime(String nomeArquivo, String nomePessoa, String nomeTime){
        String texto = "Nome: " + nomePessoa + " Time: " + nomeTime;
        gerarArquivo(nomeArquivo,texto);
    }

    public static boolean verificarArquivoExisteOuVazio(String nomeArquivo){
        File gpxfile = new File("Arquivos", nomeArquivo);
        return gpxfile.exists() && gpxfile.length() != 0;
    }
}
