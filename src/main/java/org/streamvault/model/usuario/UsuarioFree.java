package org.streamvault.model.usuario;

public class UsuarioFree extends Usuario {
    // Constructor vacío
    public UsuarioFree() {
        super();
    }
    // Constructor con parámetros
    public UsuarioFree(String username, String email, String password) {
        super(username, email, password);
    }
    // Métodos sobrescritos de clase abstracta Usuario.
    @Override
    public boolean puedeVerContenido4K() {
        return false;
    }

    @Override
    public boolean puedeVerSinAnuncios() {
        return false;
    }

    @Override
    public int obtenerMaximoDispositivos() {
        return 1;
    }
}
