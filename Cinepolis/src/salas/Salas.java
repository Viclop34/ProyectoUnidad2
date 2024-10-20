package salas;

import asientos.Asientos;
import java.time.LocalDate;

public class Salas {

    String idSalas;
    int numeroSala;
    int capacidadAsientos;
    Asientos[][] matrizAsientos; // ESTO ES UNA MATRIZ
    LocalDate horaDeFuncion;
    int cantidadAsientosVIP;
    int cantidadAsientosPremium;
    String pelicula;


    public Salas(String id, int numeroSala, int capacidadAsientos, Asientos[][] matrizAsientos, int cantidadAsientosVIP, int cantidadAsientosPremium, String pelicula) {
        this.idSalas = id;
        this.capacidadAsientos = capacidadAsientos;
        this.matrizAsientos = matrizAsientos;
        this.cantidadAsientosVIP = cantidadAsientosVIP;
        this.cantidadAsientosPremium = cantidadAsientosPremium;
        this.pelicula = pelicula;
        this.numeroSala = numeroSala;

    }

    //Getters
    public String getIdSalas() {
        return idSalas;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

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

    public void setMatrizAsientos(Asientos[][] matrizAsientos) {
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

    public String mostrarDatosSala() {
        String datosSalas = String.format("ID: %s  Numero de sala: %d, Capacidad de asientos: %s, Cantidad Asientos VIP: %d, Cantidad Asientos Premium: %d", idSalas, numeroSala, capacidadAsientos, cantidadAsientosVIP, cantidadAsientosPremium);
        return datosSalas;
    }

    public void mostrarAsientos() {
        String filas = "ABCDEFGHIJKL";
        for (int i = 0; i < matrizAsientos.length; i++) {
            char filaAsientos = filas.charAt(i);
            for (int j = 0; j < matrizAsientos[i].length; j++) {
                String vistaAsientos = String.format("%c%d", filaAsientos, j + 1);
                System.out.print(vistaAsientos + "  ");
            }
            System.out.println();
        }
    }

    public boolean comprobarDisponibilidadAsiento(String asientoSeleccionado) {
        String filas = "ABCDEFGHIJKL";
        char fila = asientoSeleccionado.charAt(0);
        int columna = Integer.parseInt(asientoSeleccionado.substring(1)) - 1;

        int filaIndice = filas.indexOf(fila);

        if (filaIndice >= 0 && columna >= 0 && columna < matrizAsientos[0].length) {
            Asientos asiento = matrizAsientos[filaIndice][columna];
            if (asiento.estaOcupado()) {
                return false; // El asiento está ocupado
            } else {
                asiento.ocuparAsiento(); // Marcar asiento como ocupado
                // Mostrar el tipo de asiento
                System.out.println("Has seleccionado un asiento " + asiento.getTipoAsiento());
                return true; // El asiento está disponible y se ocupa
            }
        } else {
            System.out.println("El asiento seleccionado no es válido.");
            return false;
        }
    }

    public Asientos obtenerAsiento(String asientoSeleccionado) {
        for (int i = 0; i < matrizAsientos.length; i++) {
            for (int j = 0; j < matrizAsientos[i].length; j++) {
                if (matrizAsientos[i][j].getNumeroAsiento().equals(asientoSeleccionado)) {
                    return matrizAsientos[i][j];
                }
            }
        }
        return null;
    }
}