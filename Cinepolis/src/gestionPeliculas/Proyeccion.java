package gestionPeliculas;

import peliculas.Pelicula;
import salas.Salas;

public class Proyeccion {
    public Pelicula pelicula;
    public String horario;
    public Salas sala;

    public Proyeccion(Pelicula pelicula, String horario, Salas salas) {
        this.pelicula = pelicula;
        this.horario = horario;
        this.sala= salas;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public String getHorario() {
        return horario;
    }

    public Salas getSala() {
        return sala;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setSala(Salas sala) {
        this.sala = sala;
    }
}