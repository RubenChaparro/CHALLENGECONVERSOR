package divisas;

public class ConvertidorMonedaExtranjera {


    public ConvertidorMonedaExtranjera() {
    }

    public double aMonedaExtranjera(double divisaCambio1,double divisaCambio2) {
        return divisaCambio1 * divisaCambio2;
    }

    public double aMonedaLocal( double divisaCambio1, double divisaCambio2) {
        return divisaCambio1 / divisaCambio2;
    }
}
