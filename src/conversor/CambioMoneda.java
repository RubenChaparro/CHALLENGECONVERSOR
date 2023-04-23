package conversor;

import java.text.DecimalFormat;

public class CambioMoneda {
    String resultado;

    public CambioMoneda() {
    }

    DecimalFormat format = new DecimalFormat("0.00");

    public String aMonedaExtranjera(double divisaOrigen, double divisaCambio, double cantidad) {
        resultado = Double.toString(cantidad);
        if (divisaOrigen != divisaCambio) {
        resultado = format.format(cantidad * ((divisaOrigen * Divisas.PESO.getCambio())/divisaCambio));
        return resultado;
    } else {
        return resultado;
    }
}
}
