package conversor;

import java.text.DecimalFormat;

public class CambioMoneda {
    String resultado;

    public CambioMoneda() {
    }

    // Instamciamos la clase DecimalFormat para que nos muestre 2 digitos despues
    // del punto
    DecimalFormat format = new DecimalFormat("0.00");

    public String aMonedaExtranjera(double divisaOrigen, double divisaCambio, double cantidad) {
        // Convertimos a String eel resultado ya que es el tipo de dato quee acepta
        // JLabel en addText()
        resultado = Double.toString(cantidad);

        // Si se seleciona la misma moneda en ambos JCombox es devuelve el mismo
        // resultado si no se realiza la operacion
        if (divisaOrigen != divisaCambio) {
            resultado = format.format(cantidad * ((divisaOrigen * Divisas.PESO.getCambio()) / divisaCambio));
            return resultado;
        } else {
            return resultado;
        }
    }
}
