package org.streamvault.model.usuario;

public class UsuarioFree extends Usuario {

    public UsuarioFree() {
        super();
    }

    public UsuarioFree(String username, String email, String password) {
        super(username, email, password);
    }

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
