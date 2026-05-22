package org.streamvault.model.usuario;

public class UsuarioPremium extends Usuario {

    public UsuarioPremium() {
        super();
    }

    public UsuarioPremium(String username, String email, String password) {
        super(username, email, password);
    }

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
