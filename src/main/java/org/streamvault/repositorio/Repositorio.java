package org.streamvault.repositorio;

import org.streamvault.model.usuario.Usuario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Repositorio {
    private List<Usuario> usuarios;

    public Repositorio() {
        this.usuarios = new ArrayList<>();
    }

    public void registrarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public Usuario buscarPorUsername(String username) {
        Iterator<Usuario> it = usuarios.iterator();
        while (it.hasNext()) {
            Usuario u = it.next();
            if (u.getUsername().equalsIgnoreCase(username)) {
                return u;
            }
        }
        return null;
    }

    public boolean eliminarUsuario(String username) {
        Iterator<Usuario> it = usuarios.iterator();
        while (it.hasNext()) {
            Usuario u = it.next();
            if (u.getUsername().equalsIgnoreCase(username)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }
}
