package org.streamvault.model.contenido;

// Representa una película que hereda de Contenido
public class Pelicula extends Contenido {

    // Guarda datos propios de la película
    private int duracion;
    private String director;
    private String clasificacion;

    // Crea objeto vacío
    public Pelicula() {
    }

    // Inicializa atributos de la película
    public Pelicula(String id, String titulo, String genero, int anio, double calificacion, int duracion, String director, String clasificacion) {
        super(id, titulo, genero, anio, calificacion); // Usa constructor de Contenido
        this.duracion = duracion;
        this.director = director;
        this.clasificacion = clasificacion;
    }

    // Reproduce la película
    @Override
    public void reproducir() {
        System.out.println("Reproduciendo película: " + getTitulo());
    }

    // Devuelve información de la película
    @Override
    public String getInfo() {
        return "Pelicula: " + getTitulo() + " | Director: " + director + " | Duración: " + duracion + " min | Año: " + getAnio() + " | Clasificación: " + clasificacion + " | Calificación: " + getCalificacion();
    }

    // Pausa la película
    @Override
    public void pausar() {
        System.out.println("Película pausada: " + getTitulo());
    }

    // Detiene la película
    @Override
    public void detener() {
        System.out.println("Película detenida: " + getTitulo());
    }

    // Adelanta la película
    @Override
    public void adelantar(int segundos) {
        System.out.println("Adelantando " + segundos + " segundos en: " + getTitulo());
    }

    // Retrocede la película
    @Override
    public void retroceder(int segundos) {
        System.out.println("Retrocediendo " + segundos + " segundos en: " + getTitulo());
    }

    // Accede y cambia duración
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    // Accede y cambia director
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Accede y cambia clasificación
    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}
