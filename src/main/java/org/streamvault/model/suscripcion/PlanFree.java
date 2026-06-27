package org.streamvault.model.suscripcion;

public record PlanFree(double precio, int limiteHoras, boolean conAnuncios) implements TipoPlan {
    public PlanFree() {
        this(0.0, 10, true);
    }

    @Override
    public double getPrecio() {
        return precio;
    }
}