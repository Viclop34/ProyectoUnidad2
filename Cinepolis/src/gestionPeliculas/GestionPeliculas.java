package gestionPeliculas;

import peliculas.Pelicula;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GestionPeliculas {
    public Scanner scanner = new Scanner(System.in);
    public ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
    public ArrayList<Pelicula> proximosEstrenos = new ArrayList<>();
    public ArrayList<Pelicula> carteleraActual = new ArrayList<>();
    ArrayList<Pelicula> peliculasEstrenadas = new ArrayList<>();

    // Mostrar cartelera actual
    public void mostrarCartelera() {
        System.out.println("Películas en cartelera:");
        for (Pelicula pelicula : carteleraActual) {
            System.out.println(" - " + pelicula.getTitulo() + " (Estrenada el: " + pelicula.getFechaEstreno() + ")");
        }
    }

    // Registrar película
    public void registrarPelicula(Pelicula pelicula) {
        listaPeliculas.add(pelicula);
        System.out.println("Película agregada exitosamente.");
    }


    public String generarIdPelicula(String titulo, String autor) {
        char letraUno = titulo.charAt(0);
        char letraDos = autor.charAt(autor.length() - 1);
        int numeroAleatorio = ThreadLocalRandom.current().nextInt(1, 3000);
        LocalDate fecha = LocalDate.now();
        int diaActual = fecha.getDayOfMonth();
        return String.format("P-%c%c-%d%d", letraUno, letraDos, numeroAleatorio, diaActual);
    }


    // Modificar película existente
    public void modificarPelicula(String titulo) {
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Modificar película: " + titulo);
                System.out.print("Nuevo título: ");
                pelicula.setTitulo(scanner.nextLine());

                System.out.print("Nueva duración (minutos): ");
                pelicula.setDuracion(scanner.nextLine());

                System.out.print("Nuevo género: ");
                pelicula.setGenero(scanner.nextLine());

                System.out.print("Nueva clasificación: ");
                pelicula.setClasificacion(scanner.nextLine());

                System.out.print("Nueva sinopsis: ");
                pelicula.setSinopsis(scanner.nextLine());

                System.out.println("Película modificada exitosamente.");
                return;
            }
        }
        System.out.println("Película no encontrada.");
    }

    // Agregar película a próximos estrenos
    public void agregarProximoEstreno(Pelicula pelicula) {
        proximosEstrenos.add(pelicula);
        System.out.println("Película '" + pelicula.getTitulo() + "' agregada a próximos estrenos.");
    }

    // Agregar película a cartelera
    public void agregarACartelera(Pelicula pelicula) {
        carteleraActual.add(pelicula);
        System.out.println("Película '" + pelicula.getTitulo() + "' agregada a cartelera.");
    }


    // Mostrar próximos estrenos
    public void mostrarProximosEstrenos() {
        System.out.println("Próximos estrenos:");
        for (Pelicula pelicula : proximosEstrenos) {
            System.out.println(" - " + pelicula.getTitulo() + " (Fecha de estreno: " + pelicula.getFechaEstreno() + ")");
        }
    }

    // Actualizar cartelera: mover películas de "próximos estrenos" a "cartelera" si ya se estrenaron
    public void actualizarCartelera() {
        LocalDate hoy = LocalDate.now();

        for (Pelicula pelicula : proximosEstrenos) {
            if (pelicula.getFechaEstreno().isBefore(hoy) || pelicula.getFechaEstreno().isEqual(hoy)) {
                agregarACartelera(pelicula);
                peliculasEstrenadas.add(pelicula);
            }
        }
        proximosEstrenos.removeAll(peliculasEstrenadas);
    }

    public void modificarProximoEstreno(ArrayList<Pelicula> listaPeliculas) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID de la película que desea modificar: ");
        String idPelicula = scanner.nextLine();

        // Buscar la película por su ID
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getIdPelicula().equals(idPelicula)) {
                System.out.println("Detalles actuales de la película:");
                System.out.println("Título: " + pelicula.getTitulo());
                System.out.println("Duración: " + pelicula.getDuracion());
                System.out.println("Género: " + pelicula.getGenero());
                System.out.println("Clasificación: " + pelicula.getClasificacion());
                System.out.println("Sinopsis: " + pelicula.getSinopsis());
                System.out.println("Autor: " + pelicula.getAutor());
                System.out.println("Fecha de Estreno: " + pelicula.getFechaEstreno());

                // Modificar detalles
                System.out.print("Ingrese el nuevo título (o presione Enter para mantenerlo): ");
                String nuevoTitulo = scanner.nextLine();
                if (!nuevoTitulo.isEmpty()) {
                    pelicula.setTitulo(nuevoTitulo);
                }

                System.out.print("Ingrese la nueva duración (o presione Enter para mantenerla): ");
                String nuevaDuracion = scanner.nextLine();
                if (!nuevaDuracion.isEmpty()) {
                    pelicula.setDuracion(nuevaDuracion);
                }

                System.out.print("Ingrese el nuevo género (o presione Enter para mantenerlo): ");
                String nuevoGenero = scanner.nextLine();
                if (!nuevoGenero.isEmpty()) {
                    pelicula.setGenero(nuevoGenero);
                }

                System.out.print("Ingrese la nueva clasificación (o presione Enter para mantenerla): ");
                String nuevaClasificacion = scanner.nextLine();
                if (!nuevaClasificacion.isEmpty()) {
                    pelicula.setClasificacion(nuevaClasificacion);
                }

                System.out.print("Ingrese la nueva sinopsis (o presione Enter para mantenerla): ");
                String nuevaSinopsis = scanner.nextLine();
                if (!nuevaSinopsis.isEmpty()) {
                    pelicula.setSinopsis(nuevaSinopsis);
                }

                System.out.print("Ingrese el nuevo autor (o presione Enter para mantenerlo): ");
                String nuevoAutor = scanner.nextLine();
                if (!nuevoAutor.isEmpty()) {
                    pelicula.setAutor(nuevoAutor);
                }

                System.out.println("Detalles de la película actualizados correctamente.");
                return;
            }
        }
        System.out.println("No se encontró ninguna película con el ID especificado.");
    }

    public void modificarCartelera() {


        System.out.print("Ingrese el ID de la película que desea modificar o eliminar: ");
        String idPelicula = scanner.nextLine();

        // Buscar la película por su ID
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getIdPelicula().equals(idPelicula)) {System.out.println("\n¿Qué desea hacer con esta película?");
                System.out.println("1. Modificar detalles");
                System.out.println("2. Eliminar película");
                System.out.println("3. Cancelar");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer

                switch (opcion) {
                    case 1: // Modificar detalles
                        // Modificar detalles
                        System.out.print("Ingrese el nuevo título (o presione Enter para mantenerlo): ");
                        String nuevoTitulo = scanner.nextLine();
                        if (!nuevoTitulo.isEmpty()) {
                            pelicula.setTitulo(nuevoTitulo);
                        }

                        System.out.print("Ingrese la nueva duración (o presione Enter para mantenerla): ");
                        String nuevaDuracion = scanner.nextLine();
                        if (!nuevaDuracion.isEmpty()) {
                            pelicula.setDuracion(nuevaDuracion);
                        }

                        System.out.print("Ingrese el nuevo género (o presione Enter para mantenerlo): ");
                        String nuevoGenero = scanner.nextLine();
                        if (!nuevoGenero.isEmpty()) {
                            pelicula.setGenero(nuevoGenero);
                        }

                        System.out.print("Ingrese la nueva clasificación (o presione Enter para mantenerla): ");
                        String nuevaClasificacion = scanner.nextLine();
                        if (!nuevaClasificacion.isEmpty()) {
                            pelicula.setClasificacion(nuevaClasificacion);
                        }

                        System.out.print("Ingrese la nueva sinopsis (o presione Enter para mantenerla): ");
                        String nuevaSinopsis = scanner.nextLine();
                        if (!nuevaSinopsis.isEmpty()) {
                            pelicula.setSinopsis(nuevaSinopsis);
                        }

                        System.out.print("Ingrese el nuevo autor (o presione Enter para mantenerlo): ");
                        String nuevoAutor = scanner.nextLine();
                        if (!nuevoAutor.isEmpty()) {
                            pelicula.setAutor(nuevoAutor);
                        }

                        System.out.println("Detalles de la película actualizados correctamente.");
                        return;

                    case 2: // Eliminar película
                        System.out.print("¿Está seguro de que desea eliminar la película? (s/n): ");
                        String confirmacion = scanner.nextLine();
                        if (confirmacion.equalsIgnoreCase("s")) {
                            listaPeliculas.remove(pelicula);
                            System.out.println("Película eliminada de la cartelera.");
                        } else {
                            System.out.println("Eliminación cancelada.");
                        }
                        return;

                    case 3: // Cancelar
                        System.out.println("Operación cancelada.");
                        return;

                    default:
                        System.out.println("Opción no válida. Operación cancelada.");
                }
            }
        }
        System.out.println("No se encontró ninguna película con el ID especificado.");
    }
}
