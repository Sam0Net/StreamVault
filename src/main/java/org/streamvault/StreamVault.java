package org.streamvault;

import org.streamvault.catalogo.Catalogo;
import org.streamvault.model.contenido.Contenido;
import org.streamvault.model.contenido.Pelicula;
import org.streamvault.model.contenido.Serie;
import org.streamvault.model.contenido.Episodio;
import java.util.List;

public class StreamVault {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();

        // 1. Demostración de Upcasting (Instanciar subclases en referencias de la superclase)
        Contenido pelicula1 = new Pelicula("P01", "Inception", "Sci-Fi", 2010, 8.8, 148, "Christopher Nolan", "PG-13");
        Contenido serie1 = new Serie("S01", "Breaking Bad", "Drama", 2008, 9.5, 5);

        // 2. Composición: Agregar episodios a la serie (Requiere Downcasting para acceder a métodos específicos)
        if (serie1 instanceof Serie) {
            Serie serieConvertida = (Serie) serie1; // Downcasting
            serieConvertida.agregarEpisodio(new Episodio("E01", "Pilot", "Drama", 2008, 9.0, 1, "Pilot", 58));
            serieConvertida.agregarEpisodio(new Episodio("E02", "Cat's in the Bag...", "Drama", 2008, 8.7, 2, "Cat's in the Bag...", 48));
        }

        // 3. Gestión de datos en el Catálogo (Uso de Maps y Sets internamente)
        catalogo.agregar(pelicula1);
        catalogo.agregar(serie1);

        System.out.println("=== BUSQUEDA POR ID (Uso de Map) ===");
        Contenido encontrado = catalogo.buscarPorId("P01");
        if (encontrado != null) {
            System.out.println(encontrado.getInfo()); // Polimorfismo en acción
            encontrado.reproducir();
        }

        System.out.println("\n=== BUSQUEDA POR GENERO (Uso de Iterator y List) ===");
        List<Contenido> dramas = catalogo.buscarPorGenero("Drama");
        for (Contenido d : dramas) {
            System.out.println(d.getInfo());
        }

        System.out.println("\n=== LISTAR GENEROS UNICOS (Uso de Set) ===");
        for (String genero : catalogo.listarGeneros()) {
            System.out.println("- " + genero);
        }
    }
}
