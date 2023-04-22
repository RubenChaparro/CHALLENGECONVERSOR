package conversor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.DoubleUnaryOperator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {

    JPanel panelPrincipal;
    JComboBox<Divisas> monedasLocales;
    JComboBox<Divisas> monedasExtranjeras;
    JTextField cantidad;
    JLabel mensajeDivisas;
    JLabel resultadoDivisas;
    JButton cambiar;

    public Ventana() {
        this.setLayout(new FlowLayout());
        panelPrincipal();
    }

    private void panelPrincipal() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        this.getContentPane().add(panelPrincipal);
        panel1();
        panel2();
    }

    private void panel1() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel monedaLocal = new JLabel();
        monedaLocal.setText("Escoge tu moneda local: ");
        panel1.add(monedaLocal);

        monedasLocales = new JComboBox<>(Divisas.values());
        panel1.add(monedasLocales);

        JLabel monedaExtranjera = new JLabel();
        monedaExtranjera.setText("Escoge tu moneda Extranjera: ");
        panel1.add(monedaExtranjera);

        monedasExtranjeras = new JComboBox<>(Divisas.values());
        panel1.add(monedasExtranjeras);

        JLabel convertir = new JLabel();
        convertir.setText("Escribe la cantidad a convertir: ");
        panel1.add(convertir);
        cantidad = new JTextField();
        cantidad.setText(Double.toString(1));
        panel1.add(cantidad);
        mensajeDivisas = new JLabel();
        panel1.add(mensajeDivisas);
        resultadoDivisas = new JLabel();
        panel1.add(resultadoDivisas);
        panelPrincipal.add(panel1, BorderLayout.CENTER);

    }

    public void panel2() {
        JPanel panel2 = new JPanel();

        cambiar = new JButton("Cambiar");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Divisas divisaLocal = (Divisas) monedasLocales.getSelectedItem();
                Divisas divisaExtranjera = (Divisas) monedasExtranjeras.getSelectedItem();
                String cantidades = cantidad.getText();
                CambioMoneda conversor = new CambioMoneda();
                String resultadoDivisa = conversor.aMonedaExtranjera(divisaLocal.getCambio(),
                        divisaExtranjera.getCambio(), Double.parseDouble(cantidades));

                ActionListener btnCambiar = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        VentanaResultado ventanaResultado = new VentanaResultado();

                        ventanaResultado.mensajeDivisas.setText(
                                "De " + divisaLocal.toString() + " a " + divisaExtranjera.toString() + " es: ");
                        ventanaResultado.resultadoDivisas.setText(resultadoDivisa);

                        ventanaResultado.pack();
                        ventanaResultado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        ventanaResultado.setLocationRelativeTo(null);
                        ventanaResultado.setVisible(true);
                    }
                };
                cambiar.addActionListener(btnCambiar);

            }
        };
        monedasExtranjeras.addActionListener(listener);
        //monedasLocales.addActionListener(listener);

        JButton limpiar = new JButton("Limpiar");
        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cantidad.setText(Double.toString(1));
                cantidad.requestFocus();

            }
        });
        JButton salir = new JButton("Salir");
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel2.add(cambiar);
        panel2.add(limpiar);
        panel2.add(salir);
        panelPrincipal.add(panel2, BorderLayout.SOUTH);
    }
}
