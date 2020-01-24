package ExercicioEntradaSaida;

import java.io.InputStream;
import java.util.Scanner;
import java.io.IOException;

public class LeituraTeclado {
    public static void main(String[] args) throws IOException{
        InputStream teclado = System.in;
        Scanner scanner = new Scanner(teclado);

        while(scanner.hasNextLine()){
            String linha = scanner.nextLine();
            System.out.println(linha);
        }
    }
}
