package org.streamvault.interfaces; // Ubica la interfaz

// Define acciones básicas de reproducción
public interface Reproducible {
    // Inicia la reproducción
    void reproducir();
    // Pausa la reproducción
    void pausar();
    // Detiene la reproducción
    void detener();
    // Adelanta cierta cantidad de segundos
    void adelantar(int segundos);
    // Retrocede cierta cantidad de segundos
    void retroceder(int segundos);
}
