package divisas;

import java.text.DecimalFormat;

public class ClasePrincipal {

    public static void main(String[] args) {

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
