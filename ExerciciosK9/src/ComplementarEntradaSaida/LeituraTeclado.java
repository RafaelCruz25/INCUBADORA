package ComplementarEntradaSaida;

import java.io.*;
import java.util.Scanner;

public class LeituraTeclado {

    public static void main(String[] args) throws IOException {
        InputStream teclado = System.in;
        Scanner scanner = new Scanner(teclado);

        FileOutputStream arquivo = new FileOutputStream("teste.txt");
        PrintStream printStream = new PrintStream(arquivo);

       while(scanner.hasNextLine()){
            String linha = scanner.nextLine();
            printStream.println(linha);
       }
    }
}
