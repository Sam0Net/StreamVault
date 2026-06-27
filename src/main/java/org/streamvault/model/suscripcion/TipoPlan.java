package org.streamvault.model.suscripcion;

import java.io.Serializable;
import org.streamvault.model.suscripcion.*;

public sealed interface TipoPlan extends Serializable permits PlanFree, PlanBasico, PlanPremium {
    double getPrecio();
}
