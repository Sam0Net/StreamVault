package org.streamvault.catalogo;

import org.streamvault.model.contenido.Contenido;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Catalogo {
    // Atributos
    private Map<String, Contenido> contenidos;
    private Set<String> generos;
    // Constructor

    // Métodos
    public void agregar(int c){
        System.out.println("Agregar episodio");
    }
    public Contenido buscarPorId(Contenido id){
        return id;
    }
    public List buscarPorGenero(List g){
        return g;
    }
    public Set<String> listarGeneros(){
    }
    public void eliminar(int id){

    }
}
