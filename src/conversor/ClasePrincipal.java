package conversor;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class ClasePrincipal {

    public static void main(String[] args) {

        JFrame convertidor = new JFrame("Convertidor");

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

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


        JPanel panel2 = new JPanel();

        JLabel monedaExtranjera = new JLabel();
        monedaExtranjera.setText("Escoge tu moneda Extranjera: ");
        panel2.add(monedaExtranjera);

        JComboBox monedasExtranjeras = new JComboBox();
        monedasExtranjeras.addItem(Divisas.DOLLAR);
        monedasExtranjeras.addItem(Divisas.EUROS);
        monedasExtranjeras.addItem(Divisas.LIBRASESTERLINAS);
        monedasExtranjeras.addItem(Divisas.YEN);
        monedasExtranjeras.addItem(Divisas.WON);
        monedasExtranjeras.addItem(Divisas.PESO);
        panel2.add(monedasExtranjeras);


        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel convertir = new JLabel();
        convertir.setText("Escribe la cantidad a convertir: ");
        panel3.add(convertir);
        JTextField cantidad = new JTextField();
        panel3.add(cantidad);


        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel textoResultado = new JLabel();
        textoResultado.setText("Tu cambio de " + "a " + "es: ");
        panel4.add(textoResultado);

        JLabel resultado = new JLabel();
        resultado.setText("Tu cambio de " + "a " + "es: ");
        panel4.add(resultado);


        JPanel panel5 = new JPanel();
        convertidor.setLayout(new GridBagLayout());

        JButton cambiar = new JButton("Cambiar");
        JButton limpiar = new JButton("Limpiar");
        JButton salir = new JButton("Salir");


        panel5.add(cambiar);
        panel5.add(limpiar);
        panel5.add(salir);



        Box contenedor1 = Box.createVerticalBox();
        //FlowLayout dispocicion = new FlowLayout(FlowLayout.LEFT);
       //
        Box contenedor2 = Box.createVerticalBox();


        GridBagConstraints posicionContenedor = new GridBagConstraints();




        contenedor1.add(panel1);
        contenedor1.add(panel2);
        contenedor1.add(panel3);
        contenedor1.add(panel4);
        posicionContenedor.gridx = 0;
        posicionContenedor.gridy = 0;
        convertidor.add(contenedor1,posicionContenedor);

        contenedor2.add(panel5);
        posicionContenedor.gridx = 0;
        posicionContenedor.gridy = 1;
        convertidor.add(contenedor2, posicionContenedor);




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
