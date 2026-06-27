package org.streamvault.model.suscripcion;

public record PlanBasico(double precio, int limiteHoras, boolean conAnuncios) implements TipoPlan {
    public PlanBasico() {
        this(9.9, 30, false);
    }

    @Override
    public double getPrecio() {
        return precio;
    }
}
