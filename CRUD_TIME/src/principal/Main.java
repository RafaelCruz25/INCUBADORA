package principal;

import entidade.Membro;
import entidade.Time;
import gerencia.GerenciaTime;

import javax.swing.*;

public class Main {

    public static final int TIME = 1;
    public static final int PESSOA = 2;
    public static final int SAIR = 3;

    public static final int ADICIONAR = 1;
    public static final int REMOVER = 2;
    public static final int ALTERAR = 3;
    public static final int LISTAR = 4;
    public static final int VOLTAR_MENU_PRINCIPAL = 5;

    public  static GerenciaTime gerenciaTime;

    public static void main(String[] args) {
       gerenciaTime = new GerenciaTime();

        int opcaoMenu = 0;
        int opcaoSubMenu = 0;
        String arquivo = "";



        System.out.println(arquivo);


       do {
           opcaoMenu = Integer.parseInt(pegarValores(getMenu()));
           switch (opcaoMenu) {
               case 1:
                   opcaoSubMenu = Integer.parseInt(pegarValores(getSubMenu()));
                   validarOpcaoSubMenu(opcaoSubMenu, opcaoMenu);
                   break;
               case 2:
                   opcaoSubMenu = Integer.parseInt(pegarValores(getSubMenu()));
                   validarOpcaoSubMenu(opcaoSubMenu, opcaoMenu);
                   break;
               case 3:
                   salvarDadosArquivos();
                   System.exit(0);
                   break;
               default:
                   mostrarMensagem("Opção inválida ! Informe um número entre 1 e 3.");
           }

       }while(opcaoMenu != SAIR);

    }

    public static void validarOpcaoSubMenu(int opcaoSubMenu, int opcaoMenu){
        if(opcaoSubMenu == ADICIONAR){
            if(opcaoMenu == TIME){
                adicionarTime();
            }else if(opcaoMenu == PESSOA){
                adicionarMembro();
            }

        }else if(opcaoSubMenu == REMOVER){

        }else if(opcaoSubMenu == ALTERAR){

        }else if(opcaoSubMenu == LISTAR){

        }else if(opcaoSubMenu == VOLTAR_MENU_PRINCIPAL){

        }
    }

    private static void adicionar(int opcaoMenu){
        if(opcaoMenu == TIME){
            adicionarTime();
        }else if(opcaoMenu == PESSOA){
            adicionarMembro();
        }
    }

    private static void adicionarMembro(){
        String nomeMembro = "";
        int opcaoTime;

        nomeMembro = pegarValores("Informe o nome: ");
        String times = "";

        int contador = 1;
        for (Time time : gerenciaTime.getArrayGerenciaTime()) {
            times = times + contador + ". PARA " + time.getNomeTime() + "\n";
            contador++;
        }

        opcaoTime = Integer.parseInt(pegarValores(times));
        opcaoTime--;
        Time time = gerenciaTime.getArrayGerenciaTime().get(opcaoTime);

        Membro membro = new Membro(nomeMembro);
        time.getArrayMembro().add(membro);

    }

    private static void adicionarTime(){
        String nomeTime = "";
        nomeTime = pegarValores("Insira o nome do Time: ");
        Time time = new Time(nomeTime);
        gerenciaTime.getArrayGerenciaTime().add(time);
    }

    private static void salvarDadosArquivos(){
        String membros = "";
        String times = "";

        for (Time time:gerenciaTime.getArrayGerenciaTime()) {

            for (Membro membro:time.getArrayMembro()) {

                membros = membros + membro.getNome() + ",";
                times = times + time.getNomeTime() + "-" + membros;

                membros = "";
            }
        }

       ManipuladorArquivo.salvarArquivo("arquivos", times);

        System.out.println(times);
        //mostrarMensagem(times);
    }

    private static String getMenu(){
        return "MENU: \n" +
                "1. PARA TIME\n" +
                "2. PARA PESSOA. \n" +
                "3. PARA SAIR.";
    }

    private static String getSubMenu(){
        return "MENU: \n" +
                "1. PARA ADICIONAR\n" +
                "2. PARA REMOVER. \n" +
                "3. PARA ALTERAR. \n" +
                "4. PARA LISTAR. \n" +
                "5. PARA VOLTAR MENU PRINCIPAL";
    }

    public static void mostrarMensagem(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static String pegarValores(String mensagem){
        return JOptionPane.showInputDialog(null, mensagem);
    }

}
