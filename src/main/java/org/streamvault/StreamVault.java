package org.streamvault;
import org.streamvault.catalogo.Catalogo;
import org.streamvault.model.contenido.Contenido;
import org.streamvault.model.contenido.Pelicula;
import org.streamvault.model.contenido.Serie;
import java.util.List;
public class StreamVault {
    static void main(String[] args) {
        Catalogo catalogo = new Catalogo();

        Pelicula p1 = new Pelicula("P01", "The Matrix", "Sci-Fi", 1999, 4.8, 136, "the Wachowski sisters", "R");
        Serie s1 = new Serie("S01", "Mr. Robot", "Drama", 2015, 4.5, 4);

        catalogo.agregar(p1);
        catalogo.agregar(s1);

        System.out.println("--- Búsqueda por ID ---");
        Contenido resultadoId = catalogo.buscarPorId("P01");
        if (resultadoId != null) {
            System.out.println(resultadoId.getInfo());
            resultadoId.reproducir();
        }

        System.out.println("\n--- Búsqueda por Género ---");
        List<Contenido> dramas = catalogo.buscarPorGenero("Drama");
        for (Contenido c : dramas) {
            System.out.println(c.getInfo());
        }

        System.out.println("\n--- Géneros Registrados ---");
        for (String genero : catalogo.listarGeneros()) {
            System.out.println("- " + genero);
        }
    }
}
