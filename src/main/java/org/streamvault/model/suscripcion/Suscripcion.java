package org.streamvault.model.suscripcion;

import java.io.Serializable;
import java.time.LocalDate;

public class Suscripcion implements Serializable {
    // Atributos [cite: 195]
    private TipoPlan plan;
    private LocalDate inicio;
    private LocalDate fin;

    public Suscripcion(TipoPlan plan) {
        this.plan = plan;
        this.inicio = LocalDate.now();
        this.fin = this.inicio.plusMonths(1);
    }

    // Verifica autonomamente si el plan esta vigente comparando fechas
    public boolean estaActiva() {
        LocalDate hoy = LocalDate.now();
        return (!hoy.isBefore(inicio)) && (!hoy.isAfter(fin));
    }

    // Incrementa la vigencia del plan actual
    public void renovar() {
        this.inicio = LocalDate.now();
        this.fin = this.inicio.plusMonths(1);
    }

    // Finaliza la vigencia de la suscripcion
    public void cancelar() {
        this.fin = LocalDate.now();
    }

    // Getters y Setters
    public TipoPlan getPlan() {
        return plan;
    }

    public void setPlan(TipoPlan plan) {
        this.plan = plan;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }
}
