package conversor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaResultado extends JFrame {

    public VentanaResultado() {

        this.setLayout(new FlowLayout());
        panelPrincipal();
        
    }

    JPanel panelPrincipal = new JPanel();
    JLabel mensajeDivisas = new JLabel();
    JLabel resultadoDivisas = new JLabel();

    public void panelPrincipal() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        this.getContentPane().add(panelPrincipal);
        Divisas();
    }

    public void Divisas() {

        mensajeDivisas = new JLabel();
        panelPrincipal.add(mensajeDivisas, BorderLayout.NORTH);

        resultadoDivisas = new JLabel();
        panelPrincipal.add(resultadoDivisas, BorderLayout.SOUTH);

        
    }

        public void accionBoton(JComboBox<Divisas> monedasLocales, JComboBox<Divisas> monedasExtranjeras, JTextField cantidad) {
        
    }
}

