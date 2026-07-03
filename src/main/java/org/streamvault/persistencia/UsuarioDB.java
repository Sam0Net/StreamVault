package org.streamvault.persistencia;

import org.streamvault.conexion.Conexion;
import org.streamvault.model.usuario.Usuario;
import org.streamvault.model.usuario.UsuarioPremium;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuarioDB {
    public void guardar(Usuario usuario) {
        String query = "INSERT INTO usuarios (nombre, email, tipo_usuario, contrasena) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getEmail());
            ps.setString(4, usuario.getPassword());
            // Determina el tipo de usuario dinamicamente mediante polimorfismo/instancia
            String tipo = (usuario instanceof UsuarioPremium) ? "Premium" : "Free";
            ps.setString(3, tipo);

            ps.executeUpdate();
            System.out.println("Usuario " + usuario.getUsername() + " guardado en DB.");
        } catch (Exception e) {
            System.err.println("Error al guardar usuario: " + e.getMessage());
        }
    }
}
