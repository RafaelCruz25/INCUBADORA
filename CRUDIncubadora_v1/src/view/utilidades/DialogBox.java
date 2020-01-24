package view.utilidades;

import javax.swing.*;

public class DialogBox {

    public static String inputDialog(String text){
        return JOptionPane.showInputDialog(text);
    }

    public static int inputDialogInteger(String text){
        return Integer.parseInt(JOptionPane.showInputDialog(null, text));
    }

    public static void messageDialog(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }
}
