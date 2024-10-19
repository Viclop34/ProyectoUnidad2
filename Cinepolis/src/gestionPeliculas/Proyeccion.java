package gestionPeliculas;

import peliculas.Pelicula;
import salas.Salas;

import java.time.LocalDate;

public class Proyeccion {
    public Pelicula pelicula;
    public LocalDate horario;
    public Salas sala;

    public Proyeccion(Pelicula pelicula, LocalDate horario, Salas salas) {
        this.pelicula = pelicula;
        this.horario = horario;
        this.sala= salas;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public LocalDate getHorario() {
        return horario;
    }

    public Salas getSala() {
        return sala;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setHorario(LocalDate horario) {
        this.horario = horario;
    }

    public void setSala(Salas sala) {
        this.sala = sala;
    }
}