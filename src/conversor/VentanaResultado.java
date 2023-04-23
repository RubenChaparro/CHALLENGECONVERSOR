package conversor;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaResultado extends JFrame {

    public VentanaResultado() {

        this.setLayout(new FlowLayout());
        panelPrincipal();

    }

    // Atributos de la ventana
    JPanel panelPrincipal, panelBotones, panelEtiquetas;
    JLabel mensajeDivisas, resultadoDivisas;
    JButton btnCerrar;

    public void panelPrincipal() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(2, 1));
        this.getContentPane().add(panelPrincipal);
        Divisas();
        panelBotones();
    }

    public void Divisas() {
        panelEtiquetas = new JPanel();
        panelEtiquetas.setLayout(new GridLayout(2, 1));

        mensajeDivisas = new JLabel();

        // Centramos el texto del Jlabel
        mensajeDivisas.setHorizontalAlignment(SwingConstants.CENTER);
        mensajeDivisas.setVerticalAlignment(SwingConstants.CENTER);
        panelEtiquetas.add(mensajeDivisas);

        resultadoDivisas = new JLabel();
        resultadoDivisas.setHorizontalAlignment(SwingConstants.CENTER);
        resultadoDivisas.setVerticalAlignment(SwingConstants.CENTER);

        panelEtiquetas.add(resultadoDivisas);

        panelPrincipal.add(panelEtiquetas);

    }

    public void panelBotones() {
        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panelBotones.add(btnCerrar);
        panelPrincipal.add(panelBotones);

    }
}
