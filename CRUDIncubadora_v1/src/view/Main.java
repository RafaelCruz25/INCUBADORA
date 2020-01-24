package view;

import view.entidades.Pessoa;
import view.entidades.PessoaTime;
import view.entidades.Time;
import view.utilidades.Arquivo;
import view.utilidades.DialogBox;

import javax.swing.*;
import java.io.*;

public class Main {
    public static final String NOME_ARQUIVO_TIME = "times.txt";
    public static final String NOME_ARQUIVO_PESSOA = "pessoas.txt";

    public static final int TIME = 1;
    public static final int PESSOA = 2;
    public static final int SAIR = 3;

    public static void main(String[] args) throws IOException {
        menu();
    }

    private static void menu() throws IOException {
        int opcaoMenu;

        do {
            opcaoMenu = DialogBox.inputDialogInteger("Menu:\n1-Times\n2-Pessoas\n3-Sair");
            switch (opcaoMenu) {
                case 1:
                    subMenu(opcaoMenu);
                    break;
                case 2:
                    subMenu(opcaoMenu);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    DialogBox.messageDialog("Opção inválida!");
                    break;
            }
        } while (opcaoMenu != 3);
    }

    private static void subMenu(int opcaoMenu) throws IOException {
        int opcaoSubMenu;

        String nome;

        opcaoSubMenu = DialogBox.inputDialogInteger("Submenu:\n 1 - Adicionar\n 2 - Editar\n 3 - Remover\n 4 - " +
                "Listar\n 5 - Voltar ao menu principal\n 6 - Sair");
        switch (opcaoSubMenu) {
            case 1:
                if (opcaoMenu == TIME) {
                    nome = DialogBox.inputDialog("Digite o nome do Time: ");
                    Time.adicionarTime(nome, NOME_ARQUIVO_TIME);
                } else {
                    int opcaoTime = 0;

                    if (!Arquivo.verificarArquivoExisteOuVazio(NOME_ARQUIVO_TIME)) {
                        DialogBox.messageDialog("Não existe times cadastrados!");
                        menu();
                    } else {
                        nome = DialogBox.inputDialog("Digite o nome da Pessoa: ");
                        Pessoa.adicionarPessoa(nome, NOME_ARQUIVO_PESSOA);

                        opcaoTime = DialogBox.inputDialogInteger(Time.gerarListaDeTimes(NOME_ARQUIVO_TIME));
                        PessoaTime.salvarPessoaTime(NOME_ARQUIVO_TIME, nome, opcaoTime, "times_pessoa.txt");
                    }
                }
                break;
            case 2:
                if (opcaoMenu == TIME) {
                    int opcao = 0;
                    if (!Arquivo.verificarArquivoExisteOuVazio(NOME_ARQUIVO_TIME)) {
                        DialogBox.messageDialog("Não existe times cadastrados!");
                        menu();
                    } else {

                        opcao = DialogBox.inputDialogInteger(Time.gerarListaDeTimes(NOME_ARQUIVO_TIME));

                        String textoEditar = DialogBox.inputDialog("Digite o novo nome do time: ");
                        Time.editarTime(NOME_ARQUIVO_TIME, opcao, textoEditar);
                    }
                } else {
                    int opcao = 0;
                    if (!Arquivo.verificarArquivoExisteOuVazio(NOME_ARQUIVO_TIME)) {
                        DialogBox.messageDialog("Não existe times cadastrados!");
                        menu();
                    } else {

                        opcao = DialogBox.inputDialogInteger(Time.gerarListaDeTimes(NOME_ARQUIVO_PESSOA));

                        String textoEditar = DialogBox.inputDialog(JOptionPane.showInputDialog("Digite o novo nome do time: "));
                        Pessoa.editarPessoa(NOME_ARQUIVO_PESSOA, opcao, textoEditar);
                    }
                }
                break;
            case 3:
                int opcao = 0;
                if (opcaoMenu == TIME) {
                    if (!Arquivo.verificarArquivoExisteOuVazio(NOME_ARQUIVO_TIME)) {
                        DialogBox.messageDialog("Não existe times cadastrados!");
                        menu();
                    } else {

                        opcao = DialogBox.inputDialogInteger(Time.gerarListaDeTimes(NOME_ARQUIVO_TIME));

                        Time.excluirTime(NOME_ARQUIVO_TIME, opcao);
                    }
                } else {
                    if (!Arquivo.verificarArquivoExisteOuVazio(NOME_ARQUIVO_TIME)) {
                        DialogBox.messageDialog("Não existe pessoas cadastradas!");
                        menu();
                    } else {

                        opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                                Pessoa.gerarListaDePessoas(NOME_ARQUIVO_PESSOA)));

                        Pessoa.excluirPessoa(NOME_ARQUIVO_PESSOA, opcao);
                    }
                }
                break;
            case 4:
                if (opcaoMenu == TIME) {
                    if (Arquivo.verificarArquivoExisteOuVazio(NOME_ARQUIVO_TIME)) {
                        DialogBox.messageDialog(Time.listarTime(NOME_ARQUIVO_TIME));
                    } else {
                        DialogBox.messageDialog("Não existe times cadastrados");
                    }
                } else {
                    if (Arquivo.verificarArquivoExisteOuVazio(NOME_ARQUIVO_PESSOA)) {
                        DialogBox.messageDialog(Pessoa.listarPessoa(NOME_ARQUIVO_PESSOA));
                    } else {
                        DialogBox.messageDialog("Não existe pessoas cadastradas");
                    }
                }
                break;
            case 5:
                menu();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                DialogBox.messageDialog("Opção inválida!");
                break;
        }
    }
}
