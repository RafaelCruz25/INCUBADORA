package ExercicioEntradaSaida;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class EscritaArquivo {
    public static void main(String[] args) throws IOException {
        FileOutputStream arquivo = new FileOutputStream("saida.txt");
        PrintStream printStream = new PrintStream(arquivo);

        printStream.println("Primeira linha!!");
        printStream.println("segunda linha!!");
        printStream.println("terceira linha!!");

    }
}
