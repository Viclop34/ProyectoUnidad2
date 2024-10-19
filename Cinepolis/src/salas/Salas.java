package salas;

import asientos.Asientos;
import gestionPeliculas.Proyeccion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Salas {

    ArrayList<Proyeccion> listaProyecciones= new ArrayList<>();
    String idSalas;
    int capacidadAsientos;
    String[][] matrizAsientos; // ESTO ES UNA MATRIZ
    Asientos tipoAsiento;
    LocalDate horaDeFuncion;
    int cantidadAsientosVIP;
    int cantidadAsientosPremium;
    String pelicula;

    public Salas(String id, int capacidadAsientos, String [][] matrizAsientos, Asientos tipoAsiento, LocalDate horaDeFuncion, int cantidadAsientosVIP, int cantidadAsientosPremium, String pelicula) {
        this.idSalas = id;
        this.capacidadAsientos = capacidadAsientos;
        this.matrizAsientos = matrizAsientos;
        this.tipoAsiento = tipoAsiento;
        this.horaDeFuncion = horaDeFuncion;
        this.cantidadAsientosVIP = cantidadAsientosVIP;
        this.cantidadAsientosPremium = cantidadAsientosPremium;
        this.pelicula = pelicula;
        this.listaProyecciones = new ArrayList<>();
    }

    //Getters
    public String getIdSalas() {return idSalas;}

    public int getCapacidadAsientos() {
        return capacidadAsientos;
    }

    public String[][] getmatrizAsientos() {
        return matrizAsientos;
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

    public ArrayList<Proyeccion> getProyecciones() {return listaProyecciones;}


    //Setters
    public void setId(String id) {
        this.idSalas = id;
    }

    public void setCapacidadAsientos(int capacidadAsientos) {
        this.capacidadAsientos = capacidadAsientos;
    }

    public void setMatrizAsientos(String [][] matrizAsientos) {
        this.matrizAsientos = matrizAsientos;
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

    public String mostrarDatosSala(){
        String datosSalas = String.format("ID: %s, Capacidad de asientos: %s, MatrizAsientos: %s, Tipo de asiento: %s, Hora de función: %s, Cantidad Asientos VIP: %d, Cantidad Asientos Premium: %d", idSalas, capacidadAsientos, matrizAsientos, tipoAsiento, horaDeFuncion,cantidadAsientosVIP,cantidadAsientosPremium );
        return datosSalas;
    }

    public void agregarProyeccion(Proyeccion proyeccion) {
        listaProyecciones.add(proyeccion);
    }
}