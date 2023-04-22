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

public class VentanaResultado extends JFrame {

    public VentanaResultado() {

        this.setLayout(new FlowLayout());
        panelPrincipal();
        
    }

    JPanel panelPrincipal, panelBotones, panelEtiquetas;
    JLabel mensajeDivisas, resultadoDivisas;
    JButton cerrar;
    

    public void panelPrincipal() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        this.getContentPane().add(panelPrincipal);
        Divisas();
        panelBotones();
    }

    public void Divisas() {
        panelEtiquetas = new JPanel();
        panelEtiquetas.setLayout(new BorderLayout());

        mensajeDivisas = new JLabel();
        panelEtiquetas.add(mensajeDivisas, BorderLayout.NORTH);

        resultadoDivisas = new JLabel();
        panelEtiquetas.add(resultadoDivisas, BorderLayout.SOUTH);

        panelPrincipal.add(panelEtiquetas, BorderLayout.NORTH);

        
    }

    public void panelBotones() {
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2)); 
        cerrar = new JButton("Cerrar");
        cerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panelBotones.add(cerrar);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);


    }

        public void accionBoton(JComboBox<Divisas> monedasLocales, JComboBox<Divisas> monedasExtranjeras, JTextField cantidad) {
        
    }
}

