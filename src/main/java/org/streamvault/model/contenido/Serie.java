package org.streamvault.model.contenido;

import java.util.ArrayList;
import java.util.List;

// Representa una serie que hereda de Contenido
public class Serie extends Contenido {

    // Guarda datos de la serie
    private int temporadas;
    private List<Episodio> episodios;

    // Crea objeto vacío con lista de episodios
    public Serie() {
        this.episodios = new ArrayList<>();
    }

    // Inicializa atributos de la serie
    public Serie(String id, String titulo, String genero, int anio, double calificacion, int temporadas) {
        super(id, titulo, genero, anio, calificacion); // Usa constructor de Contenido
        this.temporadas = temporadas;
        this.episodios = new ArrayList<>();
    }

    // Reproduce la serie
    @Override
    public void reproducir() {
        System.out.println("Reproduciendo serie: " + getTitulo());
    }

    // Devuelve información de la serie
    @Override
    public String getInfo() {
        return "Serie: " + getTitulo() + " | Temporadas: " + temporadas + " | Episodios: " + episodios.size() + " | Año: " + getAnio() + " | Calificación: " + getCalificacion();
    }

    // Agrega un episodio a la lista
    public void agregarEpisodio(Episodio episodio) {
        episodios.add(episodio);
    }

    // Pausa la serie
    @Override
    public void pausar() {
        System.out.println("Serie pausada: " + getTitulo());
    }

    // Detiene la serie
    @Override
    public void detener() {
        System.out.println("Serie detenida: " + getTitulo());
    }

    // Adelanta la serie
    @Override
    public void adelantar(int segundos) {
        System.out.println("Adelantando " + segundos + " segundos en serie: " + getTitulo());
    }

    // Retrocede la serie
    @Override
    public void retroceder(int segundos) {
        System.out.println("Retrocediendo " + segundos + " segundos en serie: " + getTitulo());
    }

    // Accede y cambia temporadas
    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    // Accede y cambia lista de episodios
    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }
}
