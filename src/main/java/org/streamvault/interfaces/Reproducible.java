package org.streamvault.interfaces;

public interface Reproducible {
    void reproducir();
    void pausar();
    void detener();
    void adelantar(int segundos);
    void retroceder(int segundos);
}
