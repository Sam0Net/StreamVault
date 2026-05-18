package org.streamvault.model.contenido;

public class Episodio extends Contenido {
    private int numero;
    private String tituloEpisodio;
    private int duracion;

    public Episodio() {}

    public Episodio(String id, String titulo, String genero, int anio, double calificacion, int numero, String tituloEpisodio, int duracion) {
        super(id, titulo, genero, anio, calificacion);
        this.numero = numero;
        this.tituloEpisodio = tituloEpisodio;
        this.duracion = duracion;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo episodio " + numero + ": " + tituloEpisodio);
    }

    @Override
    public String getInfo() {
        return "Episodio " + numero + ": " + tituloEpisodio + " | Duración: " + duracion + " min | Calificación: " + getCalificacion();
    }

    @Override
    public void pausar() {
        System.out.println("Episodio pausado: " + tituloEpisodio);
    }

    @Override
    public void detener() {
        System.out.println("Episodio detenido: " + tituloEpisodio);
    }

    @Override
    public void adelantar(int segundos) {
        System.out.println("Adelantando " + segundos + " segundos en episodio: " + tituloEpisodio);
    }

    @Override
    public void retroceder(int segundos) {
        System.out.println("Retrocediendo " + segundos + " segundos en episodio: " + tituloEpisodio);
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getTituloEpisodio() { return tituloEpisodio; }
    public void setTituloEpisodio(String tituloEpisodio) { this.tituloEpisodio = tituloEpisodio; }

    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }
}
