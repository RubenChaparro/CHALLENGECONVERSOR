package conversor;

// Importamos los paquetes necesarios 

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {

    // Creamos los atributos de la ventana

    JPanel panelPrincipal, panel1, panel2;
    // definimos que el JComboBox usa datos de tipo Divisa
    JComboBox<Divisas> cmbMonedasLocales, cmbMonedasExtranjeras;
    JTextField txtCantidad;
    JLabel monedaLocal, monedaExtranjera, convertir;
    JButton btnCambiar, btnLimpiar, btnSalir;

    // Constructor de la ventana
    public Ventana() {

        // Configuramos el Layout del JFrame (this hace referencia al JFrame)
        // Debemos saber elegir el Layout entre BorderLayout(Ubicacion por punto
        // cardinal), GridLayout(Ubicacion por "celdas") y FlowLayout (ubicacion por
        // espacio)
        this.setLayout(new FlowLayout());
        // Agregamos el panel principal al JFrame llamando el metodo panelPrincipal
        panelPrincipal();
    }

    private void panelPrincipal() {
        // Configramos el panel principal agragando los panel1 y panel2
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        this.getContentPane().add(panelPrincipal);
        panel1();
        panel2();
    }

    private void panel1() {
        // Configuramos el panel agrgando los elementos de este panel
        panel1 = new JPanel();
        // Establecemos el numero de filas y columnas del GridLayout
        panel1.setLayout(new GridLayout(4, 2, 10, 10));

        monedaLocal = new JLabel();
        monedaLocal.setText("Escoge tu moneda local: ");
        panel1.add(monedaLocal);

        // Creamos los JComboBox relacionandolos con el enum
        cmbMonedasLocales = new JComboBox<>(Divisas.values());
        panel1.add(cmbMonedasLocales);

        monedaExtranjera = new JLabel();
        monedaExtranjera.setText("Escoge tu moneda Extranjera: ");
        panel1.add(monedaExtranjera);

        cmbMonedasExtranjeras = new JComboBox<>(Divisas.values());
        panel1.add(cmbMonedasExtranjeras);

        convertir = new JLabel();
        convertir.setText("Escribe la cantidad a convertir: ");
        panel1.add(convertir);
        txtCantidad = new JTextField();
        panel1.add(txtCantidad);
        panelPrincipal.add(panel1, BorderLayout.CENTER);

    }

    public void panel2() {
        panel2 = new JPanel();

        btnCambiar = new JButton("Cambiar");
        ActionListener cambiar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Capturamos la excepcion si no escribimos un numero en el JTexField
                try {
                    // Creamos las diferentes variables que nos capturan las opciones que
                    // seleccionamos
                    Divisas divisaLocal = (Divisas) cmbMonedasLocales.getSelectedItem();
                    Divisas divisaExtranjera = (Divisas) cmbMonedasExtranjeras.getSelectedItem();
                    String cantidades = txtCantidad.getText();
                    // Instanciamos la clase CambioMoneda para hacer el cambio de monedas
                    CambioMoneda conversor = new CambioMoneda();
                    String resultadoDivisa = conversor.aMonedaExtranjera(divisaLocal.getCambio(),
                            divisaExtranjera.getCambio(), Double.parseDouble(cantidades));

                    // Creamos la ventana para mostrar el resultado
                    VentanaResultado ventanaResultado = new VentanaResultado();

                    ventanaResultado.mensajeDivisas.setText(
                            "De " + divisaLocal.toString() + " a " + divisaExtranjera.toString() + " es: ");
                    ventanaResultado.resultadoDivisas.setText(resultadoDivisa);

                    ventanaResultado.pack();
                    ventanaResultado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    ventanaResultado.setLocationRelativeTo(null);
                    ventanaResultado.setVisible(true);
                } catch (NumberFormatException exception) {
                    // Creamos una ventana emergente para mostrar un mensaje de error
                    JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad válida en numeros");
                }
            }
        };
        // Accion y botones para limpiar el JTextField, cerrar la ventana
        btnCambiar.addActionListener(cambiar);
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCantidad.setText(null);
                txtCantidad.requestFocus();

            }
        });
        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel2.add(btnCambiar);
        panel2.add(btnCambiar);
        panel2.add(btnSalir);
        panelPrincipal.add(panel2, BorderLayout.SOUTH);
    }
}
