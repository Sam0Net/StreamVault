package org.streamvault.model.historial;
import java.util.ArrayList;
import java.util.List;
public class Historial {
        private List<Reproduccion> registros;

        public Historial() {
            registros = new ArrayList<>();
        }
        public void agregar(Reproduccion r){
            registros.add(r);
        }
        public List<Reproduccion> ObtenerUltimos(int n){
            int inicio = Math.max(registros.size() - n, 0);

            return registros.subList(inicio, registros.size());
        }
        public void limpiar() {
            registros.clear();
        }
    }
