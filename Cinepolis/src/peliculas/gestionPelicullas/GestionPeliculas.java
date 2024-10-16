package peliculas.gestionPelicullas;

import peliculas.Pelicula;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionPeliculas extends Pelicula {
    Scanner sc = new Scanner(System.in);
    public ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
    public ArrayList<Pelicula> carteleraActual = new ArrayList<>();
    public ArrayList<Pelicula> proximosEstrenos = new ArrayList<>();

    public GestionPeliculas(String id, String titulo, String duracion, String genero, String clasificacion, String sinopsis, String autor, LocalDate fechaEstreno) {
        super(id, titulo, duracion, genero, clasificacion, sinopsis, autor,fechaEstreno);
    }

    public void registrarPelicula(Pelicula pelicula) {

        this.listaPeliculas.add(pelicula);
        System.out.println("Película agregada exitosamente.");

    }

    public void modificarPelicula(String titulo) {
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {

                System.out.println("Modificar película: " + titulo);

                System.out.print("Nuevo título: ");
                pelicula.setTitulo(sc.nextLine());

                System.out.print("Nueva duración (minutos): ");
                pelicula.setDuracion(sc.nextLine());
                sc.nextLine();

                System.out.print("Nuevo género: ");
                pelicula.setGenero(sc.nextLine());

                System.out.print("Nueva clasificación: ");
                pelicula.setClasificacion(sc.nextLine());

                System.out.print("Nueva sinopsis: ");
                pelicula.setSinopsis(sc.nextLine());

                System.out.println("Película modificada exitosamente.");
                return;
            }

        }
    }


    public void agregarProximoEstreno(Pelicula pelicula) {
        proximosEstrenos.add(pelicula);
        System.out.println("Película '" + pelicula.getTitulo() + "' agregada a próximos estrenos.");
    }

    public void agregarACartelera(Pelicula pelicula) {
        carteleraActual.add(pelicula);
        System.out.println("Película '" + pelicula.getTitulo() + "' agregada a cartelera.");
    }

    public void mostrarCartelera() {
        System.out.println("Películas en cartelera:");
        for (Pelicula pelicula : carteleraActual) {
            System.out.println(" - " + pelicula.getTitulo() + " (Estrenada el: " + pelicula.getFechaEstreno() + ")");
        }
    }
    public void mostrarProximosEstrenos() {
        System.out.println("Próximos estrenos:");
        for (Pelicula pelicula : proximosEstrenos) {
            System.out.println(" - " + pelicula.getTitulo() + " (Fecha de estreno: " + pelicula.getFechaEstreno() + ")");
        }
    }

    public void actualizarCartelera() {
        LocalDate hoy = LocalDate.now();
        ArrayList<Pelicula> peliculasEstrenadas = new ArrayList<>();

        for (Pelicula pelicula : proximosEstrenos) {
            if (pelicula.getFechaEstreno().isBefore(hoy) || pelicula.getFechaEstreno().isEqual(hoy)) {
                agregarACartelera(pelicula);
                peliculasEstrenadas.add(pelicula);
            }
        }
        proximosEstrenos.removeAll(peliculasEstrenadas);
    }
}

