package datos;

import java.time.LocalDate;

public class Reserva {
    private int id;
    private Stand stand;
    private Editorial editorial;
    private LocalDate fechaReserva;
    private double costoTotalAcordado;
    private double montoPagado;
    private boolean descuentoProntoPagoAplicado;

    public Reserva(int id, Stand stand, Editorial editorial, LocalDate fechaReserva,
                   double costoTotalAcordado, double montoPagado, boolean descuentoProntoPagoAplicado) {
        this.id = id;
        this.stand = stand;
        this.editorial = editorial;
        this.fechaReserva = fechaReserva;
        this.costoTotalAcordado = costoTotalAcordado;
        this.montoPagado = montoPagado;
        this.descuentoProntoPagoAplicado = descuentoProntoPagoAplicado;
    }

    public int getId() { return id; }
    public Stand getStand() { return stand; }
    public Editorial getEditorial() { return editorial; }
    public LocalDate getFechaReserva() { return fechaReserva; }
    public double getCostoTotalAcordado() { return costoTotalAcordado; }
    public double getMontoPagado() { return montoPagado; }
    public boolean isDescuentoProntoPagoAplicado() { return descuentoProntoPagoAplicado; }

    @Override
    public String toString() {
        return String.format("Reserva #%d | Stand #%d (%s) -> Editorial: %s | Fecha: %s | Costo Acordado: $%.2f | Pagado: $%.2f | Pronto Pago: %s",
                id, stand.getId(), stand.getNombre(), editorial.getNombre(), fechaReserva,
                costoTotalAcordado, montoPagado, descuentoProntoPagoAplicado ? "Sí" : "No");
    }
}