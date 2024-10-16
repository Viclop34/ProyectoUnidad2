package salas.gestionSalas;

import asientos.Asientos;
import peliculas.Pelicula;
import peliculas.gestionPelicullas.Proyeccion;
import salas.Salas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class GestionSalas extends Salas {
    public ArrayList<Salas> listaSalas= new ArrayList<>();

    public GestionSalas(String id, int capacidadAsientos, ArrayList Asientos, Asientos tipoAsiento, LocalDate horaDeFuncion, int cantidadAsientosVIP, int cantidadAsientosPremium, String pelicula) {
        super(id, capacidadAsientos,Asientos, tipoAsiento, horaDeFuncion, cantidadAsientosVIP, cantidadAsientosPremium, pelicula);
    }
    public void registrarSalas(Salas salas) {

        this.listaSalas.add(salas);
        System.out.println("Sala agregada exitosamente.");

    }
    public void agregarProyeccion(int IdSalas, Pelicula pelicula, String horario) {
        for (Salas salas : listaSalas) {
            if (salas.getIdSalas().equals(IdSalas)) {
                Proyeccion proyeccion = new Proyeccion(pelicula, horario);
                salas.agregarProyeccion(proyeccion);
                System.out.println("Proyección de '" + pelicula.getTitulo() + "' agregada a la sala " + IdSalas + " a las " + horario + ".");
                return;
            }
        }
        System.out.println("La sala " + IdSalas + " no existe.");
    }
    public void mostrarProyecciones(int IdSalas) {
        for (Salas sala : listaSalas) {
            if (sala.getIdSalas().equals(IdSalas)){
                System.out.println("Proyecciones en la sala " + IdSalas + ":");
                for (Proyeccion proyeccion : sala.getProyecciones()) {
                    System.out.println(" - " + proyeccion.getPelicula().getTitulo() + " a las " + proyeccion.getHorario());
                }
                return;
            }
        }
        System.out.println("La sala " + IdSalas + " no existe.");
    }
public String generarIdSalas() {
    int diaActual = LocalDate.now().getDayOfMonth();
    int numeroAleatorio = new Random().nextInt(100000 - 50) + 50;
    return String.format("CO-%d-%d-%d", listaSalas.size() + 1, numeroAleatorio, diaActual);
}
}
