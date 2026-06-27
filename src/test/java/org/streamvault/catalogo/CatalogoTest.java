package org.streamvault.catalogo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.streamvault.model.contenido.Contenido;
import org.streamvault.model.contenido.Pelicula;
import org.streamvault.model.contenido.Serie;

import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class CatalogoTest {
    private Catalogo catalogo;
    private Contenido pelicula;
    private Contenido serie;

    @BeforeEach
    public void setUp() {
        catalogo = new Catalogo();
        pelicula = new Pelicula("P01", "Interstellar", "Sci-Fi", 2014, 8.6, 169, "Christopher Nolan", "PG-13");
        serie = new Serie("S01", "Dark", "Sci-Fi", 2017, 8.8, 3);
    }

    @Test
    public void testAgregarYBuscarPorId() {
        catalogo.agregar(pelicula);
        Contenido resultado = catalogo.buscarPorId("P01");
        assertNotNull(resultado, "El contenido no debería ser nulo");
        assertEquals("Interstellar", resultado.getTitulo());
    }

    @Test
    public void testBuscarPorGeneroConIterator() {
        catalogo.agregar(pelicula);
        catalogo.agregar(serie);
        List<Contenido> resultado = catalogo.buscarPorGenero("Sci-Fi");
        assertEquals(2, resultado.size(), "Deberían encontrarse dos contenidos de Ciencia Ficción");
    }

    @Test
    public void testListarGenerosSinDuplicados() {
        catalogo.agregar(pelicula);
        catalogo.agregar(serie); // Ambos pertenecen al género "Sci-Fi"
        Set<String> generos = catalogo.listarGeneros();
        assertEquals(1, generos.size(), "El conjunto Set no debe admitir géneros duplicados");
        assertTrue(generos.contains("Sci-Fi"));
    }

    @Test
    public void testEliminarContenido() {
        catalogo.agregar(pelicula);
        catalogo.eliminar("P01");
        Contenido resultado = catalogo.buscarPorId("P01");
        assertNull(resultado, "El contenido debió ser removido del catálogo");
    }
}
