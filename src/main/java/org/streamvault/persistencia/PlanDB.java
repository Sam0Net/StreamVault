package org.streamvault.persistencia;

import org.streamvault.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;

public class PlanDB {
    public void guardar(String nombre, double precio, Integer limiteHoras, boolean conAnuncios, Integer perfiles, boolean descargas) {
        String query = "INSERT INTO planes (nombre, precio, limite_horas, con_anuncios, perfiles, descargas) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, nombre);
            ps.setDouble(2, precio);

            if (limiteHoras == null) ps.setNull(3, Types.INTEGER);
            else ps.setInt(3, limiteHoras);

            ps.setBoolean(4, conAnuncios);

            if (perfiles == null) ps.setNull(5, Types.INTEGER);
            else ps.setInt(5, perfiles);

            ps.setBoolean(6, descargas);

            ps.executeUpdate();
            System.out.println("Plan '" + nombre + "' registrado exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al guardar plan: " + e.getMessage());
        }
    }
}
