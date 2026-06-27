package org.streamvault.model.suscripcion;

public record PlanPremium(double precio, int perfiles, boolean descargas) implements TipoPlan {
    public PlanPremium() {
        this(19.9, 4, true);
    }

    @Override
    public double getPrecio() {
        return precio;
    }
}
