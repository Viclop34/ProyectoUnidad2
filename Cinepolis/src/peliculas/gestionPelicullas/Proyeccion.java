package peliculas.gestionPelicullas;

import peliculas.Pelicula;

public class Proyeccion {
    private Pelicula pelicula;
    private String horario;

    public Proyeccion(Pelicula pelicula, String horario) {
        this.pelicula = pelicula;
        this.horario = horario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public String getHorario() {
        return horario;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}