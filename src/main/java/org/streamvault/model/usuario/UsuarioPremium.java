package org.streamvault.model.usuario;

public class UsuarioPremium extends Usuario {
    // Constructor vacío
    public UsuarioPremium() {
        super();
    }
    // Constructor con parámetros
    public UsuarioPremium(String username, String email, String password) {
        super(username, email, password);
    }
    // Métodos sobrescritos de clase abstracta Usuario.
    @Override
    public boolean puedeVerContenido4K() {
        return true;
    }

    @Override
    public boolean puedeVerSinAnuncios() {
        return true;
    }

    @Override
    public int obtenerMaximoDispositivos() {
        return 4;
    }
}
