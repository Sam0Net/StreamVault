package org.streamvault.model.usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {
    private Usuario usuarioFree;
    private Usuario usuarioPremium;

    @BeforeEach
    public void setUp() {
        // Demostración de Upcasting en el entorno de pruebas
        usuarioFree = new UsuarioFree("user_free", "free@streamvault.com", "pass123");
        usuarioPremium = new UsuarioPremium("user_premium", "premium@streamvault.com", "pass456");
    }

    //Modifica y recupera atributos como el nombre de usuario y el correo electrónico.
    @Test
    public void testEncapsulamientoYDatosBase() {
        assertEquals("user_free", usuarioFree.getUsername());
        assertEquals("free@streamvault.com", usuarioFree.getEmail());

        usuarioFree.setUsername("nuevo_username");
        assertEquals("nuevo_username", usuarioFree.getUsername());
    }
    // Invoca el método de validación de calidad de video sobre una instancia de cuenta gratuita.
    @Test
    public void testRestriccionCalidad4KUsuarioFree() {
        // Evalúa el comportamiento polimórfico heredado de la clase abstracta
        assertFalse(usuarioFree.puedeVerContenido4K(), "Un usuario Free no debería tener permitido el acceso a 4K");
    }

    // Invoca el mismo método de validación de calidad de video pero sobre una instancia de cuenta de pago.
    @Test
    public void testAccesoCalidad4KUsuarioPremium() {
        // Evalúa el comportamiento polimórfico heredado de la clase abstracta
        assertTrue(usuarioPremium.puedeVerContenido4K(), "Un usuario Premium debe tener permitido el acceso a 4K");
    }
}
