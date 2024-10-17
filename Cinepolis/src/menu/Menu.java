package menu;

import asientos.Asientos;
import boletos.Boletos;
import cine.Cine;
import gestionPeliculas.GestionPeliculas;
import peliculas.Pelicula;
import resources.Rol;
import salas.Salas;
import salas.gestionSalas.GestionSalas;
import usuarios.Usuarios;
import usuarios.admin.Admin;
import usuarios.cliente.Cliente;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Cine cine = new Cine();
    private GestionPeliculas gestionPeliculas = new GestionPeliculas();
    private  Pelicula pelicula;
    private GestionSalas gestionSalas;
    private Salas salas;
    private Boletos boletos;
    private Asientos asientos;

// HESM050818MMNRLRA1

    public void login() {
        int intentosMaximos = 5;
        int intentosUsuario = 0;

        while (intentosUsuario < intentosMaximos) {
            System.out.println("\nBienvenido\n");
            System.out.println("¿Ya cuentas con cuenta cinepolis? Si/No");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("si")) {
                System.out.println("Inicia sesión para continuar");
                System.out.println("Ingresa tu usuario: ");
                String usuario = scanner.nextLine();

                System.out.println("Ingresa tu contraseña: ");
                String contrasenia = scanner.nextLine();

                Usuarios usuarioEnSesion = cine.validarInicioDeSesion(usuario, contrasenia);

                if (usuarioEnSesion != null) {
                    if (usuarioEnSesion.getRol() == Rol.CLIENTE) {
                        Cliente clienteEnSesion = (Cliente) usuarioEnSesion;
                        this.mostrarMenuCliente(clienteEnSesion);
                        return;
                    } else {
                        Admin administradorEnSesion = (Admin) usuarioEnSesion;
                        this.mostrarMenuAdmin(administradorEnSesion);
                        intentosUsuario = 0;
                    }
                }


                intentosUsuario = mostrarErrorInicioSesion(intentosUsuario);
            } else {
                // Registrar un nuevo cliente si no tiene cuenta
                System.out.println("Registrate!!");

                System.out.println("Ingresa tu nombre: ");
                String nombre = scanner.nextLine();
                System.out.println("Ingresa tus apellidos: ");
                String apellidos = scanner.nextLine();

                String id = cine.generarIdCliente(nombre, apellidos);

                System.out.println("Ingresa tu año de nacimiento: ");
                int anio = scanner.nextInt();
                System.out.println("Ingresa tu mes de nacimiento: ");
                int mes = scanner.nextInt();
                System.out.println("Ingresa tu día de nacimiento: ");
                int dia = scanner.nextInt();

                LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
                scanner.nextLine(); // Limpiar buffer

                System.out.println("Ingresa tu CURP: ");
                String curpCliente = scanner.nextLine();

                while(!cine.validacionCurp(curpCliente)){

                    System.out.println("Ingresa una CURP válida: ");
                    curpCliente = scanner.nextLine();
                    cine.validacionCurp(curpCliente);
                }

                System.out.println("Ingresa tu dirección:");
                String direccionCliente = scanner.nextLine();

                System.out.println("Crea tu contraseña:");
                String contraseniaCliente = scanner.nextLine();
                Cliente cliente = new Cliente(id, nombre, apellidos, fechaNacimiento, contraseniaCliente, curpCliente, direccionCliente);
                cine.registrarCliente(cliente);

                System.out.println("Registro exitoso!");
                System.out.println("Tu Usuario para iniciar sesión es: " + id + " No lo pierdas!!");

                // Acceder al menú del cliente después del registro
                this.mostrarMenuCliente(cliente);
            }
        }
        System.out.println("Intentos máximos permitidos alcanzados.");
    }

    private int mostrarErrorInicioSesion(int intentosUsuario) {
        System.out.println("Usuario o contraseña incorrectos, Intenta de nuevo");
        return intentosUsuario + 1;
    }

    private void mostrarMenuCliente(Cliente clienteEnSesion) {
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("** BIENVENID@ A CINEPOLIS **");
            System.out.println("1. Comprar boletos");
            System.out.println("2. Ver películas de cartelera");
            System.out.println("3. Ver mis reservas");
            System.out.println("4. Ver próximos estrenos");
            System.out.println("5. Salir");
            System.out.println("Selecciona una opción");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Implementar lógica para comprar boletos
                    break;
                case 2:
                    cine.mostrarCartelera();
                    break;
                case 3:
                    // Implementar lógica para ver reservas
                    break;
                case 4:
                    cine.mostrarProximosEstrenos();// Implementar lógica para ver próximos estrenos
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor seleccione de nuevo.");
            }
        }
    }

    private void mostrarMenuAdmin(Admin administradorEnSesion) {
        int opcion = 0;
        while (opcion != 7) {
            System.out.println("\n*BIENVENIDO*");
            System.out.println("1. Registrar película");
            System.out.println("2. Modificar película");
            System.out.println("3. Listar peliculas");
            System.out.println("4. Modificar cartelera");
            System.out.println("5. Agregar comida a menu");
            System.out.println("6. Modificar menu");
            System.out.println("7. Salir");

            System.out.print("\nSeleccione una opción:\n");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.println("** Registrar Nueva Película **");

                    System.out.print("Ingrese el título de la película: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Ingrese el autor de la película: ");
                    String autor = scanner.nextLine();

                    String idPelicula = cine.generarIdPelicula(titulo, autor);

                    System.out.print("Ingrese el género de la película: ");
                    String genero = scanner.nextLine();

                    System.out.println("Ingrese la clasificacion de la pelicula: ");
                    String clasificacion = scanner.nextLine();

                    System.out.print("Ingrese la duración de la película (en minutos): ");
                    String duracion = scanner.nextLine();
                    scanner.nextLine(); // Limpiar el buffer

                    System.out.print("Ingrese la sinopsis de la película: ");
                    String sinopsis = scanner.nextLine();

                    System.out.println("Ingrese el dia del estreno");
                    int diaEstreno = scanner.nextInt();

                    System.out.println("Ingrese el mes del estreno");
                    int mesEstreno = scanner.nextInt();

                    System.out.println("Ingrese el ano del estreno");
                    int anoEstreno = scanner.nextInt();
                    validarFecha(diaEstreno, mesEstreno, anoEstreno);

                    LocalDate fechaEstreno = LocalDate.of(anoEstreno, mesEstreno, diaEstreno);
                    Pelicula nuevaPelicula = new Pelicula(idPelicula,titulo,duracion,genero,clasificacion, sinopsis, autor, fechaEstreno);
                    cine.registrarPelicula(nuevaPelicula);
                    cine.agregarACartelera(nuevaPelicula);

                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("MODIFICAR PELICULAS");
                    System.out.println("Ingrese el nombre de la pelicula que desea modificar:");
                    String nombre = scanner.nextLine();
                    cine.modificarPelicula(nombre);
                    break;
                case 3:
                    //REGISTRAR PROXIMOS ESTRENOS
                    cine.listarPeliculas();
                    break;
                case 4:
                    System.out.println("MODIFICAR CARTELERA");
                    cine.modificarCartelera();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Hasta pronto.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }


    public static boolean validarFecha(int dia, int mes, int ano) {
        try {
            LocalDate fechaEstreno = LocalDate.of(ano, mes, dia);

            LocalDate fechaActual = LocalDate.now();

            if (fechaEstreno.isBefore(fechaActual)) {
                System.out.println("La fecha de estreno no puede ser en el pasado.");
                return false;
            }

            System.out.println("Fecha de Estreno válida: " + fechaEstreno);
            return true;

        } catch (DateTimeParseException | IllegalArgumentException e) {
            System.out.println("Fecha inválida. Por favor, asegúrese de ingresar un día, mes y año correctos.");
            return false;
        }
    }
}
