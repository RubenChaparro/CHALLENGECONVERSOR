package conversor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        Object divisaLocal = monedasLocales.getSelectedItem();
        System.out.println(divisaLocal.toString());

        // Divisa divisaLocal = new Divisa(monedasLocales);

        JLabel monedaExtranjera = new JLabel();
        monedaExtranjera.setText("Escoge tu moneda Extranjera: ");
        panel1.add(monedaExtranjera);

        monedasExtranjeras = new JComboBox<>(Divisas.values());
        panel1.add(monedasExtranjeras);

        JLabel convertir = new JLabel();
        convertir.setText("Escribe la cantidad a convertir: ");
        panel1.add(convertir);
        JTextField cantidad = new JTextField();
        panel1.add(cantidad);
        JLabel texto = new JLabel();
        panel1.add(texto);
        JLabel resultado = new JLabel();
        panel1.add(resultado);
        panelPrincipal.add(panel1, BorderLayout.CENTER);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Divisas divisaLocal = (Divisas) monedasLocales.getSelectedItem();
                // Divisas divisaExtranjera = (Divisas) monedasExtranjeras.getSelectedItem();

                ActionListener listener2 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Divisas divisaLocal = (Divisas) monedasLocales.getSelectedItem();
                        Divisas divisaExtranjera = (Divisas) monedasExtranjeras.getSelectedItem();
                        CambioMoneda conversor = new CambioMoneda();
                        String resultadoDivisa = conversor.aMonedaExtranjera(divisaLocal.getCambio(), divisaExtranjera.getCambio());
                        texto.setText("De " + monedasLocales.getSelectedItem().toString() + " a "
                                + monedasExtranjeras.getSelectedItem().toString() + " es: ");
                                resultado.setText(resultadoDivisa);
                    }
                };
                monedasExtranjeras.addActionListener(listener2);
            }
        };
        monedasLocales.addActionListener(listener);
    }

    public void panel2() {
        JPanel panel2 = new JPanel();

        JButton cambiar = new JButton("Cambiar");

        JButton limpiar = new JButton("Limpiar");
        JButton salir = new JButton("Salir");

        panel2.add(cambiar);
        panel2.add(limpiar);
        panel2.add(salir);
        panelPrincipal.add(panel2, BorderLayout.SOUTH);
    }

}
