package conversor;

// Creamos la clase enum con las variables de la moneda con su respectivo valor
public enum Divisas {
    DOLLAR(4750.23),
    EUROS(5121.94),
    LIBRASESTERLINAS(5808.11),
    YEN(36.33),
    WON(3.67),
    PESO(1);
    // Atributos de la clase Enum

    private final double cambio;

    Divisas(double cambio) {
        this.cambio = cambio;
    }
    // Obtenemos el cambio de la moneda

    public double getCambio() {
        return cambio;
    }
}
