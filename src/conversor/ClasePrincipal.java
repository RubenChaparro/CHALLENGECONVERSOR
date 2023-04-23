package conversor;

// importamos el paquete de javax.swing
import javax.swing.*;

public class ClasePrincipal {

    public static Divisas selectDivisa;

    // Innstaciamos la clase ventana que nos ejecuta el programa
    public static void main(String[] args) {

        Ventana convertidor = new Ventana();
        // Adaptar la ventana al tamanho de los elementos
        convertidor.pack();
        // Cerrar la ventana en la X
        convertidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Centrar la ventana en la pantalla
        convertidor.setLocationRelativeTo(null);
        // Mostrar la ventana
        convertidor.setVisible(true);
    }
}
