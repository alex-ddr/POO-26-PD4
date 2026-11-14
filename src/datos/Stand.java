package datos;

public class Stand {
    private int id;
    private String nombre;
    private double metrosCuadrados;
    private double precioPorMetroCuadrado;
    private EstadoStand estado;

    public Stand(int id, String nombre, double metrosCuadrados, double precioPorMetroCuadrado, EstadoStand estado) {
        this.id = id;
        this.nombre = nombre;
        this.metrosCuadrados = metrosCuadrados;
        this.precioPorMetroCuadrado = precioPorMetroCuadrado;
        this.estado = estado;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getMetrosCuadrados() { return metrosCuadrados; }
    public double getPrecioPorMetroCuadrado() { return precioPorMetroCuadrado; }
    public EstadoStand getEstado() { return estado; }

    public double calcularPrecioTotal() {
        return metrosCuadrados * precioPorMetroCuadrado;
    }

    @Override
    public String toString() {
        return String.format("Stand #%d [%s] | %.1f m2 | $%.2f/m2 | Total: $%.2f | Estado: %s",
                id, nombre, metrosCuadrados, precioPorMetroCuadrado, calcularPrecioTotal(), estado);
    }
}