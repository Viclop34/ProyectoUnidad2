package salas;

import asientos.Asientos;
import resources.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Salas {
    String idSalas;
    int capacidadAsientos;
    List<Asientos> listaAsientos = new ArrayList<Asientos>();
    Asientos tipoAsiento;
    LocalDate horaDeFuncion;
    int cantidadAsientosVIP;
    int cantidadAsientosPremium;
    String pelicula;

    public Salas(String id, int capacidadAsientos, ArrayList listaAsientos, Asientos tipoAsiento, LocalDate horaDeFuncion, int cantidadAsientosVIP, int cantidadAsientosPremium, String pelicula) {
        this.idSalas = id;
        this.capacidadAsientos = capacidadAsientos;
        this.listaAsientos = listaAsientos;
        this.tipoAsiento = tipoAsiento;
        this.horaDeFuncion = horaDeFuncion;
        this.cantidadAsientosVIP = cantidadAsientosVIP;
        this.cantidadAsientosPremium = cantidadAsientosPremium;
        this.pelicula = pelicula;
    }

    //Getters
    public String getId() {
        return idSalas;
    }

    public int getCapacidadAsientos() {
        return capacidadAsientos;
    }

    public List<Asientos> getListaAsientos() {
        return listaAsientos;
    }

    public Asientos getTipoAsiento() {
        return tipoAsiento;
    }

    public LocalDate getHoraDeFuncion() {
        return horaDeFuncion;
    }

    public int getCantidadAsientosVIP() {
        return cantidadAsientosVIP;
    }

    public int getCantidadAsientosPremium() {
        return cantidadAsientosPremium;
    }

    public String getPelicula() {
        return pelicula;
    }

    //Setters
    public void setId(String id) {
        this.idSalas = id;
    }

    public void setCapacidadAsientos(int capacidadAsientos) {
        this.capacidadAsientos = capacidadAsientos;
    }

    public void setListaAsientos(List<Asientos> listaAsientos) {
        this.listaAsientos = listaAsientos;
    }

    public void setTipoAsiento(Asientos tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public void setHoraDeFuncion(LocalDate horaDeFuncion) {
        this.horaDeFuncion = horaDeFuncion;
    }

    public void setCantidadAsientosVIP(int cantidadAsientosVIP) {
        this.cantidadAsientosVIP = cantidadAsientosVIP;
    }

    public void setCantidadAsientosPremium(int cantidadAsientosPremium) {
        this.cantidadAsientosPremium = cantidadAsientosPremium;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }
}
