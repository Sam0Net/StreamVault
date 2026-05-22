package org.streamvault.catalogo;

import org.streamvault.model.contenido.Contenido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Catalogo {
    private Map<String, Contenido> contenidos;
    private Set<String> generos;

    public Catalogo() {
        this.contenidos = new HashMap<>();
        this.generos = new HashSet<>();
    }

    public void agregar(Contenido c) {
        contenidos.put(c.getId(), c);
        generos.add(c.getGenero());
    }

    public Contenido buscarPorId(String id) {
        return contenidos.get(id);
    }

    public List<Contenido> buscarPorGenero(String genero) {
        List<Contenido> resultado = new ArrayList<>();
        Iterator<Contenido> it = contenidos.values().iterator();
        while (it.hasNext()) {
            Contenido c = it.next();
            if (c.getGenero().equalsIgnoreCase(genero)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public Set<String> listarGeneros() {
        return generos;
    }

    public void eliminar(String id) {
        contenidos.remove(id);
    }
}
