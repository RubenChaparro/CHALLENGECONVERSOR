package conversor;

public class CambioMoneda {


    public CambioMoneda() {
    }
    
    public String aMonedaExtranjera(double divisaorigen, double divisaCambio) { return Double.toString(((divisaorigen*Divisas.PESO.getCambio())/divisaCambio)); }
}
