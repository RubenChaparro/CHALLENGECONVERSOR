package conversor;

import javax.swing.*;
import java.text.DecimalFormat;

public class ClasePrincipal {

   public static Divisas selectDivisa;
    public static void main(String[] args) {

        Ventana convertidor = new Ventana();
        convertidor.pack();
        convertidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        convertidor.setLocationRelativeTo(null);
        convertidor.setVisible(true);
        


        DecimalFormat format = new DecimalFormat("#.00");
    }
}
