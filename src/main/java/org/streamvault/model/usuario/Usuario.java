package org.streamvault.model.usuario;
import org.streamvault.model.historial.Historial;
import org.streamvault.model.suscripcion.Suscripcion;
import java.time.LocalDateTime;

public abstract class Usuario {
    // Atributos
    private Long id;
    private String username;
    private String email;
    private String password;
    private Suscripcion suscripcion;
    private Historial historial;
    private LocalDateTime fechaRegistro;
    // Constructor vacío
    public Usuario() {}
    // Constructor con parámetros
    public Usuario(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.fechaRegistro = LocalDateTime.now();
        this.historial = new Historial();
    }
    // Métodos abstract
    public abstract boolean puedeVerContenido4K();
    public abstract boolean puedeVerSinAnuncios();
    public abstract int obtenerMaximoDispositivos();
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Suscripcion getSuscripcion() { return suscripcion; }
    public void setSuscripcion(Suscripcion suscripcion) { this.suscripcion = suscripcion; }

    public Historial getHistorial() { return historial; }
    public void setHistorial(Historial historial) { this.historial = historial; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}
