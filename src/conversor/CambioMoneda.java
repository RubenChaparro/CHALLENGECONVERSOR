package conversor;

public class CambioMoneda {


    public CambioMoneda() {
    }

    public double aMonedaExtranjera(double divisaorigen, double divisaCambio) { return (divisaorigen / divisaCambio); }

    public double aMonedaLocal( double divisa1, double divisa2) {
        return divisa1 * divisa2;
    }
}
