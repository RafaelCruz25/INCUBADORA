package ComplementarEntradaSaida;

import java.io.*;
import java.util.Scanner;

public class TesteLeitura {
    public static void main(String[] args) throws IOException {

        InputStream arquivo = new FileInputStream("teste.txt");
        Scanner scanner = new Scanner(arquivo);

        FileOutputStream arquivo2 = new FileOutputStream("teste2.txt");
        PrintStream printStream = new PrintStream(arquivo2);

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            printStream.println(linha);

        }
    }
}
