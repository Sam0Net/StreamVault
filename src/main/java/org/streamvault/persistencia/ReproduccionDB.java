package org.streamvault.persistencia;

import org.streamvault.model.historial.Reproduccion;
import org.streamvault.conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReproduccionDB {

    public void guardar(int idUsuario, Reproduccion repro) {
        String query = "INSERT INTO historial_reproducciones (id_usuario, id_contenido, fecha, duracion_seg) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idUsuario);
            ps.setString(2, repro.idContenido());
            ps.setTimestamp(3, Timestamp.valueOf(repro.fecha()));
            ps.setInt(4, repro.duracionSeg());
            ps.executeUpdate();
            System.out.println("Registro insertado en la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }
    }

    public List<Reproduccion> obtenerPorUsuario(int idUsuario) {
        List<Reproduccion> lista = new ArrayList<>();
        String query = "SELECT h.id_contenido, c.titulo, h.fecha, h.duracion_seg " +
                "FROM historial_reproducciones h " +
                "JOIN contenidos c ON h.id_contenido = c.id_contenido " +
                "WHERE h.id_usuario = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idUsuario);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Reproduccion(
                            rs.getString("id_contenido"),
                            rs.getString("titulo"),
                            rs.getTimestamp("fecha").toLocalDateTime(),
                            rs.getInt("duracion_seg")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar: " + e.getMessage());
        }
        return lista;
    }

    public void actualizarDuracion(int idUsuario, String idContenido, int nuevaDuracion) {
        String query = "UPDATE historial_reproducciones SET duracion_seg = ? WHERE id_usuario = ? AND id_contenido = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, nuevaDuracion);
            ps.setInt(2, idUsuario);
            ps.setString(3, idContenido);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Registro actualizado en la base de datos.");
            } else {
                System.out.println("No se encontro el registro para actualizar.");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }

    public void eliminar(int idUsuario, String idContenido) {
        String query = "DELETE FROM historial_reproducciones WHERE id_usuario = ? AND id_contenido = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idUsuario);
            ps.setString(2, idContenido);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Registro eliminado de la base de datos.");
            } else {
                System.out.println("No se encontro el registro para eliminar.");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }
}
