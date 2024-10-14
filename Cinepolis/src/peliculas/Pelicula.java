package peliculas;

public class Pelicula {
    String idPelicula;
    String titulo;
    String duracion;
    String genero;
    String clasificacion;
    String sinopsis;
    String autor;

    public Pelicula(String id, String titulo, String duracion, String genero, String clasificacion, String sinopsis, String autor) {
        this.idPelicula = id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.sinopsis = sinopsis;
        this.autor = autor;
    }

    // Getters
    public String getId() {
        return idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDuracion() {
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

    // Setters

    public void setId(String id) {
        this.idPelicula = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDuracion(String duracion) {
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
}
