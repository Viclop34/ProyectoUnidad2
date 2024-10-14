package salas.gestionSalas;

import asientos.Asientos;
import resources.Rol;
import salas.Salas;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestionSalas extends Salas {
    public GestionSalas(String id, int capacidadAsientos, ArrayList Asientos, Asientos tipoAsiento, LocalDate horaDeFuncion, int cantidadAsientosVIP, int cantidadAsientosPremium, String pelicula) {
        super(id, capacidadAsientos,Asientos, tipoAsiento, horaDeFuncion, cantidadAsientosVIP, cantidadAsientosPremium, pelicula);
    }
}
