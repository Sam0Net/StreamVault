package org.streamvault.model.contenido;

public class Pelicula extends Contenido {
    private int duracion;
    private String director;
    private String clasificacion;

    public Pelicula() {}

    public Pelicula(String id, String titulo, String genero, int anio, double calificacion, int duracion, String director, String clasificacion) {
        super(id, titulo, genero, anio, calificacion);
        this.duracion = duracion;
        this.director = director;
        this.clasificacion = clasificacion;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo película: " + getTitulo());
    }

    @Override
    public String getInfo() {
        return "Pelicula: " + getTitulo() + " | Director: " + director + " | Duración: " + duracion + " min | Año: " + getAnio() + " | Clasificación: " + clasificacion + " | Calificación: " + getCalificacion();
    }

    @Override
    public void pausar() {
        System.out.println("Película pausada: " + getTitulo());
    }

    @Override
    public void detener() {
        System.out.println("Película detenida: " + getTitulo());
    }

    @Override
    public void adelantar(int segundos) {
        System.out.println("Adelantando " + segundos + " segundos en: " + getTitulo());
    }

    @Override
    public void retroceder(int segundos) {
        System.out.println("Retrocediendo " + segundos + " segundos en: " + getTitulo());
    }

    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }
}
