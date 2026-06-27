package org.streamvault.persistencia;

import org.streamvault.conexion.Conexion;
import org.streamvault.model.contenido.Contenido;
import org.streamvault.model.contenido.Pelicula;
import org.streamvault.model.contenido.Serie;
import org.streamvault.model.contenido.Episodio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;

public class ContenidoDB {
    public void guardar(Contenido contenido) {
        String query = "INSERT INTO contenidos (id_contenido, titulo, genero, anio, calificacion, tipo_contenido, " +
                "duracion_total, director, clasificacion, temporadas, numero_episodio, titulo_episodio) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, contenido.getId());
            ps.setString(2, contenido.getTitulo());
            ps.setString(3, contenido.getGenero());
            ps.setInt(4, contenido.getAnio());
            ps.setDouble(5, contenido.getCalificacion());

            if (contenido instanceof Pelicula pelicula) {
                ps.setString(6, "Pelicula");
                ps.setInt(7, pelicula.getDuracion());
                ps.setString(8, pelicula.getDirector());
                ps.setString(9, pelicula.getClasificacion());
                ps.setNull(10, Types.INTEGER);
                ps.setNull(11, Types.INTEGER);
                ps.setNull(12, Types.VARCHAR);
            } else if (contenido instanceof Serie serie) {
                ps.setString(6, "Serie");
                ps.setInt(7, 0);
                ps.setNull(8, Types.VARCHAR);
                ps.setNull(9, Types.VARCHAR);
                ps.setInt(10, serie.getTemporadas());
                ps.setNull(11, Types.INTEGER);
                ps.setNull(12, Types.VARCHAR);
            } else if (contenido instanceof Episodio episodio) {
                ps.setString(6, "Episodio");
                ps.setInt(7, episodio.getDuracion());
                ps.setNull(8, Types.VARCHAR);
                ps.setNull(9, Types.VARCHAR);
                ps.setNull(10, Types.INTEGER);
                ps.setInt(11, episodio.getNumero());
                ps.setString(12, episodio.getTituloEpisodio());
            }

            ps.executeUpdate();
            System.out.println("Contenido [" + contenido.getTitulo() + "] guardado exitosamente en la base de datos.");
        } catch (Exception e) {
            System.err.println("Error al guardar contenido: " + e.getMessage());
        }
    }
}