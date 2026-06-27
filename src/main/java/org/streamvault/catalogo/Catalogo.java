package org.streamvault.catalogo; // Ubica la clase

import org.streamvault.model.contenido.Contenido;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Maneja un catálogo de contenidos
public class Catalogo {
    // Guarda contenidos por id
    private Map<String, Contenido> contenidos;
    // Guarda géneros disponibles
    private Set<String> generos;

    // Inicializa estructuras
    public Catalogo() {
        this.contenidos = new HashMap<>();
        this.generos = new HashSet<>();
    }

    // Agrega contenido al catálogo
    public void agregar(Contenido c) {
        contenidos.put(c.getId(), c);
        generos.add(c.getGenero());
    }

    // Busca contenido por id
    public Contenido buscarPorId(String id) {
        return contenidos.get(id);
    }

    // Busca todos los contenidos que pertenezcan a un género específico
    public List<Contenido> buscarPorGenero(String genero) {
        // Crea una lista vacía donde se guardarán los resultados
        List<Contenido> resultado = new ArrayList<>();
        // Obtiene un iterador para recorrer todos los contenidos del catálogo
        Iterator<Contenido> it = contenidos.values().iterator();
        // Recorre cada contenido
        while (it.hasNext()) {
            Contenido c = it.next();
            // Compara el género del contenido con el género buscado (sin importar mayúsculas/minúsculas)
            if (c.getGenero().equalsIgnoreCase(genero)) {
                resultado.add(c);
            }
        }
        // Devuelve la lista con todos los contenidos encontrados
        return resultado;
    }

    // Lista géneros disponibles
    public Set<String> listarGeneros() {
        return generos;
    }

    // Elimina contenido por id
    public void eliminar(String id) {
        contenidos.remove(id);
    }
}