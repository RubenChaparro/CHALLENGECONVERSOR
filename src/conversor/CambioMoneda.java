package conversor;

import java.text.DecimalFormat;

public class CambioMoneda {

    public CambioMoneda() {
    }

    DecimalFormat format = new DecimalFormat("#.00");

    public String aMonedaExtranjera(double divisaorigen, double divisaCambio, double cantidad) {
        String resultado = format.format((cantidad * (divisaorigen * Divisas.PESO.getCambio())));
        return resultado;
    }
}
