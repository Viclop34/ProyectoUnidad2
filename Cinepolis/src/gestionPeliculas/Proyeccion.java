package gestionPeliculas;

import peliculas.Pelicula;
import salas.Salas;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Proyeccion {
    public Pelicula pelicula;
    public LocalDateTime horario;
    public Salas sala;

    public Proyeccion(Pelicula pelicula, LocalDateTime horario, Salas salas) {
        this.pelicula = pelicula;
        this.horario = horario;
        this.sala= salas;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public Salas getSala() {
        return sala;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public void setSala(Salas sala) {
        this.sala = sala;
    }

    public String mostrarDatos(){
        String datos= String.format("Id de la sala donde se proyecta: %s, Hora de proyección: %s Nombre de la pelicula: %s"
                , sala.getIdSalas(),horario, pelicula.getTitulo());
        return datos;
    }
}