package org.streamvault.persistencia;

import org.streamvault.conexion.Conexion;
import org.streamvault.model.contenido.Contenido;
import org.streamvault.model.contenido.Pelicula;
import org.streamvault.model.contenido.Serie;
import org.streamvault.model.contenido.Episodio;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ContenidoDB {
    public void guardar(Contenido contenido) {
        String query = "INSERT INTO contenidos (id_contenido, titulo, tipo_contenido, duracion_total) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, contenido.getId());
            ps.setString(2, contenido.getTitulo());

            String tipo = "Episodio";
            int duracionTotal = 0;

            // Identifica la subclase exacta para obtener su duracion correspondiente
            if (contenido instanceof Pelicula pelicula) {
                tipo = "Pelicula";
                duracionTotal = pelicula.getDuracion(); // Llama a getDuracion() de Pelicula
            } else if (contenido instanceof Serie) {
                tipo = "Serie";
                duracionTotal = 0; // Las series no tienen duracion directa en sus atributos
            } else if (contenido instanceof Episodio episodio) {
                tipo = "Episodio";
                duracionTotal = episodio.getDuracion(); // Llama a getDuracion() de Episodio
            }

            ps.setString(3, tipo);
            ps.setInt(4, duracionTotal);

            ps.executeUpdate();
            System.out.println("Contenido [" + tipo + "] " + contenido.getTitulo() + " guardado en DB.");
        } catch (Exception e) {
            System.err.println("Error al guardar contenido: " + e.getMessage());
        }
    }
}
