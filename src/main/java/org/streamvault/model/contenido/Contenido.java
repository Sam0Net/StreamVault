package org.streamvault.model.contenido; // Paquete donde está la clase

import org.streamvault.interfaces.Reproducible; // Importa la interfaz

public abstract class Contenido implements Reproducible {
    // Atributos privados
    private String id;
    private String titulo;
    private String genero;
    private int anio;
    private double calificacion;
    // Constructor vacío: permite crear objetos sin inicializar atributos de inmediato
    public Contenido() {}
    // Constructor que Inicializa atributos
    public Contenido(String id, String titulo, String genero, int anio, double calificacion) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
        this.calificacion = calificacion;
    }
    // Método abstracto que cada subclase debe implementar
    public abstract String getInfo();

    // Getters y setters para acceder/modificar atributos
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public double getCalificacion() { return calificacion; }
    public void setCalificacion(double calificacion) { this.calificacion = calificacion; }
}
