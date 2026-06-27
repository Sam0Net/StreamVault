package org.streamvault.model.contenido;
// Representa un episodio que hereda de Contenido
public class Episodio extends Contenido {
    // Guarda datos propios del episodio
    private int numero;
    private String tituloEpisodio;
    private int duracion;
    // Crea objeto vacío
    public Episodio() {}
    // Inicializa atributos del episodio
    public Episodio(String id, String titulo, String genero, int anio, double calificacion, int numero, String tituloEpisodio, int duracion) {
        super(id, titulo, genero, anio, calificacion);
        this.numero = numero;
        this.tituloEpisodio = tituloEpisodio;
        this.duracion = duracion;
    }
    //Sobreescribe en el metodo heredado
    //Devuelve información del episodio
    @Override
    public void reproducir() {
        System.out.println("Reproduciendo episodio " + numero + ": " + tituloEpisodio);
    }
    // Pausa el episodio
    @Override
    public String getInfo() {
        return "Episodio " + numero + ": " + tituloEpisodio + " | Duración: " + duracion + " min | Calificación: " + getCalificacion();
    }
    // Detiene el episodio
    @Override
    public void pausar() {
        System.out.println("Episodio pausado: " + tituloEpisodio);
    }
    // Detiene el episodio
    @Override
    public void detener() {
        System.out.println("Episodio detenido: " + tituloEpisodio);
    }

    // Adelanta el episodio
    @Override
    public void adelantar(int segundos) {
        System.out.println("Adelantando " + segundos + " segundos en episodio: " + tituloEpisodio);
    }
    // Retrocede el episodio
    @Override
    public void retroceder(int segundos) {
        System.out.println("Retrocediendo " + segundos + " segundos en episodio: " + tituloEpisodio);
    }
    // Accede y cambia número
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    // Accede y cambia título del episodio
    public String getTituloEpisodio() { return tituloEpisodio; }
    public void setTituloEpisodio(String tituloEpisodio) { this.tituloEpisodio = tituloEpisodio; }

    // Accede y cambia duración
    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }
}
