package conversor;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class ClasePrincipal {

    public static void main(String[] args) {

        JFrame convertidor = new JFrame("Convertidor");
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());


        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4,2,10,10));

        JLabel monedaLocal = new JLabel();
        monedaLocal.setText("Escoge tu moneda local: ");
        panel1.add(monedaLocal);

        JComboBox monedasLocales = new JComboBox();
        monedasLocales.addItem(Divisas.DOLLAR);
        monedasLocales.addItem(Divisas.EUROS);
        monedasLocales.addItem(Divisas.LIBRASESTERLINAS);
        monedasLocales.addItem(Divisas.YEN);
        monedasLocales.addItem(Divisas.WON);
        monedasLocales.addItem(Divisas.PESO);
        panel1.add(monedasLocales);

        JLabel monedaExtranjera = new JLabel();
        monedaExtranjera.setText("Escoge tu moneda Extranjera: ");
        panel1.add(monedaExtranjera);

        JComboBox monedasExtranjeras = new JComboBox();
        monedasExtranjeras.addItem(Divisas.DOLLAR);
        monedasExtranjeras.addItem(Divisas.EUROS);
        monedasExtranjeras.addItem(Divisas.LIBRASESTERLINAS);
        monedasExtranjeras.addItem(Divisas.YEN);
        monedasExtranjeras.addItem(Divisas.WON);
        monedasExtranjeras.addItem(Divisas.PESO);
        panel1.add(monedasExtranjeras);

        JLabel convertir = new JLabel();
        convertir.setText("Escribe la cantidad a convertir: ");
        panel1.add(convertir);
        JTextField cantidad = new JTextField();
        panel1.add(cantidad);

        JLabel textoResultado = new JLabel();
        textoResultado.setText("Tu cambio de " + "a " + "es: ");
        panel1.add(textoResultado);

        JLabel resultado = new JLabel();
        resultado.setText("Tu cambio de " + "a " + "es: ");
        panel1.add(resultado);


        JPanel panel2 = new JPanel();
        convertidor.setLayout(new FlowLayout());

        JButton cambiar = new JButton("Cambiar");
        JButton limpiar = new JButton("Limpiar");
        JButton salir = new JButton("Salir");


        panel2.add(cambiar);
        panel2.add(limpiar);
        panel2.add(salir);

        panelPrincipal.add(panel1,BorderLayout.CENTER);
        panelPrincipal.add(panel2,BorderLayout.SOUTH);

        convertidor.add(panelPrincipal);






        convertidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        convertidor.pack();
        convertidor.setLocationRelativeTo(null);
        convertidor.setVisible(true);






        double divisaProporcionada = 100000000;
        Divisas divisas = Divisas.DOLLAR;
        CambioMoneda aMonedaExtranjera = new CambioMoneda();
        CambioMoneda aMonedaLocal = new CambioMoneda();
        DecimalFormat format = new DecimalFormat("#.00");

        double aExtranjera = aMonedaExtranjera.aMonedaExtranjera(divisaProporcionada,divisas.getCambio());
        double aLocal = aMonedaLocal.aMonedaLocal(divisaProporcionada, divisas.getCambio());
        System.out.println(format.format(aLocal));
        System.out.println(format.format(aExtranjera));



    }
}
