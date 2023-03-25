package divisas;

public enum Divisas {
        DOLLAR(4750.23),
        EUROS(5121.94),
        LIBRASESTERLINAS(5808.11),
        YEN(36.33),
        WON(3.67),
        PESO(1);

        private final double cambio;
    Divisas(double cambio) {
        this.cambio = cambio;
    }

    public double getCambio() {
        return cambio;
    }
}
