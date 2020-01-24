package principal;

import java.io.*;

public class ManipuladorArquivo {

    public static String lerArquivo(String rFilename) {

        File file = new File(rFilename);
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

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

    public static void  salvarArquivo(String sFileName, String sBody) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            File root = new File(sFileName);

            if (!root.exists()) {
                root.mkdirs();
            }
            if(root.exists()){
                stringBuilder.append(lerArquivo(sFileName));
                File gpxfile = new File(root, sFileName);
                FileWriter writer = new FileWriter(gpxfile);
                stringBuilder.append(sBody);
                writer.append(stringBuilder);
                writer.flush();
                writer.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean validarArquivoExiste(String sFileName){
        boolean retorno = false;
        File root = new File(sFileName);

        if (root.exists()) {
            retorno = true;
        }

        return retorno;
    }

}
