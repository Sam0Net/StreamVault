package org.streamvault.model.contenido;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Contenido {
    private int temporadas;
    private List<Episodio> episodios;

    public Serie() {
        this.episodios = new ArrayList<>();
    }

    public Serie(String id, String titulo, String genero, int anio, double calificacion, int temporadas) {
        super(id, titulo, genero, anio, calificacion);
        this.temporadas = temporadas;
        this.episodios = new ArrayList<>();
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo serie: " + getTitulo());
    }

    @Override
    public String getInfo() {
        return "Serie: " + getTitulo() + " | Temporadas: " + temporadas + " | Episodios: " + episodios.size() + " | Año: " + getAnio() + " | Calificación: " + getCalificacion();
    }

    public void agregarEpisodio(Episodio episodio) {
        episodios.add(episodio);
    }

    @Override
    public void pausar() {
        System.out.println("Serie pausada: " + getTitulo());
    }

    @Override
    public void detener() {
        System.out.println("Serie detenida: " + getTitulo());
    }

    @Override
    public void adelantar(int segundos) {
        System.out.println("Adelantando " + segundos + " segundos en serie: " + getTitulo());
    }

    @Override
    public void retroceder(int segundos) {
        System.out.println("Retrocediendo " + segundos + " segundos en serie: " + getTitulo());
    }

    public int getTemporadas() { return temporadas; }
    public void setTemporadas(int temporadas) { this.temporadas = temporadas; }

    public List<Episodio> getEpisodios() { return episodios; }
    public void setEpisodios(List<Episodio> episodios) { this.episodios = episodios; }
}
