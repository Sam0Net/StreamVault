package org.streamvault.persistencia;

import org.streamvault.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.time.LocalDate;

public class SuscripcionDB {
    public void guardar(int idUsuario, int idPlan, LocalDate fechaInicio, LocalDate fechaFin) {
        String query = "INSERT INTO suscripciones (id_usuario, id_plan, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, idUsuario);
            ps.setInt(2, idPlan);
            ps.setDate(3, Date.valueOf(fechaInicio));
            ps.setDate(4, Date.valueOf(fechaFin));

            ps.executeUpdate();
            System.out.println("Suscripcion vinculada exitosamente al usuario ID: " + idUsuario);
        } catch (Exception e) {
            System.err.println("Error al guardar suscripcion: " + e.getMessage());
        }
    }
}