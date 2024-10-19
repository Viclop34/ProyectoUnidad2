package salas;

import asientos.Asientos;
import gestionPeliculas.Proyeccion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Salas {

    String idSalas;
    int capacidadAsientos;
    Asientos[][] matrizAsientos; // ESTO ES UNA MATRIZ
    LocalDate horaDeFuncion;
    int cantidadAsientosVIP;
    int cantidadAsientosPremium;
    String pelicula;


    public Salas(String id, int capacidadAsientos, Asientos [][] matrizAsientos, int cantidadAsientosVIP, int cantidadAsientosPremium, String pelicula) {
        this.idSalas = id;
        this.capacidadAsientos = capacidadAsientos;
        this.matrizAsientos = matrizAsientos;
        this.cantidadAsientosVIP = cantidadAsientosVIP;
        this.cantidadAsientosPremium = cantidadAsientosPremium;
        this.pelicula = pelicula;

    }

    //Getters
    public String getIdSalas() {return idSalas;}

    public int getCapacidadAsientos() {
        return capacidadAsientos;
    }

    public Asientos[][] getmatrizAsientos() {
        return matrizAsientos;
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

    public void setIdSalas(String idSalas) {
        this.idSalas = idSalas;
    }

    public void setCapacidadAsientos(int capacidadAsientos) {
        this.capacidadAsientos = capacidadAsientos;
    }

    public void setMatrizAsientos(Asientos [][] matrizAsientos) {
        this.matrizAsientos = matrizAsientos;
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

    public String mostrarDatosSala(){
        String datosSalas = String.format("ID: %s, Capacidad de asientos: %s, Cantidad Asientos VIP: %d, Cantidad Asientos Premium: %d", idSalas, capacidadAsientos,cantidadAsientosVIP,cantidadAsientosPremium );
        return datosSalas;
    }

}