package peliculas;

import java.time.LocalDateTime;

public class Pelicula {
    String idPelicula;
    String titulo;
    int duracion;
    String genero;
    String clasificacion;
    String sinopsis;
    String autor;
    LocalDateTime fechaEstreno;

    public Pelicula(String id, String titulo, int duracion, String genero, String clasificacion, String sinopsis, String autor, LocalDateTime fechaEstreno) {
        this.idPelicula = id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.sinopsis = sinopsis;
        this.autor = autor;
        this.fechaEstreno = fechaEstreno;
    }

    public String getidPelicula() {
        return idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getAutor() {
        return autor;
    }

    public String getIdPelicula() {
        return idPelicula;
    }

    public LocalDateTime getFechaEstreno() {
        return fechaEstreno;
    }


    public void setidPelicula(String id) {
        this.idPelicula = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    public void setFechaEstreno(LocalDateTime fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String mostrarDatosPeliculas(){
        String datosPelicula = String.format("ID: %s, Titulo: %s, Duración: %s, Genero: %s, Clasificación: %s, Sinopsis: %s, Autor: %s", idPelicula, titulo, duracion, genero, clasificacion, sinopsis, autor);
        return datosPelicula;
    }
}