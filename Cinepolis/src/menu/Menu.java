package menu;

import asientos.Asientos;
import boletos.Boletos;
import cine.Cine;
import gestionComida.Comida;
import gestionComida.GestionComida;
import gestionPeliculas.Proyeccion;
import peliculas.Pelicula;
import resources.CalidadAsiento;
import resources.Rol;
import resources.TipoComida;
import salas.Salas;
import salas.gestionSalas.GestionSalas;
import usuarios.Usuarios;
import usuarios.admin.Admin;
import usuarios.cliente.Cliente;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Cine cine = new Cine();
    private Pelicula pelicula;
    private GestionSalas gestionSalas;
    private Salas salas;
    private Boletos boletos;
    private Asientos asientos;
    private GestionComida gestionComida; // Asegúrate de inicializar esta variable
    private Comida comida = new Comida();

    // Constructor de la clase Menu
    public Menu() {
        this.gestionComida = new GestionComida(); // Inicializa la instancia de GestionComida
    }

    public void login() {
        int intentosMaximos = 5;
        int intentosUsuario = 0;
    // PELICULA PRUEBA
        String cIdPelicula = cine.generarIdPelicula("Locas", "Pablo");
        LocalDateTime cFechaEstreno = LocalDateTime.of(2025,7,20,5,10);

        Pelicula cNuevaPelicula = new Pelicula(cIdPelicula, "Locas", 120, "Accion", "13"
                , "fdsuhfksdhfsdjk", "Pablo", cFechaEstreno);
        cine.registrarPelicula(cNuevaPelicula);
        cine.agregarACartelera(cNuevaPelicula);
    //
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
            System.out.println("3. Ver mis reservas");;
            System.out.println("4. Salir");
            System.out.println("Selecciona una opción");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("COMPRAR BOLETOS");
                    break;
                case 2:
                    System.out.println("COMPRAR BOLETOS");
                    cine.mostrarCartelera();
                    break;
                case 3:
                    // Implementar lógica para ver reservas
                    break;
                case 4:

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
        while (opcion != 14) { // Cambié el límite a 9 para coincidir con las opciones
            System.out.println("\n*BIENVENIDO*");
            System.out.println("1. Registrar película");
            System.out.println("2. Modificar película");
            System.out.println("3. Listar peliculas");
            System.out.println("4. Modificar cartelera");
            System.out.println("5. Listar Cartelera");
            System.out.println("6. Agregar comida a menu");
            System.out.println("7. Modificar comida");
            System.out.println("8. Listar comida");
            System.out.println("9. Crear Sala");
            System.out.println("10. Lisar Sala");
            System.out.println("11. Crear Proyeccion");
            System.out.println("12. Listar Proyecciones");
            System.out.println("13. Listar clientes");
            System.out.println("14. Salir");

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

                    System.out.println("Ingrese la clasificación de la película: ");
                    String clasificacion = scanner.nextLine();

                    System.out.print("Ingrese la duración de la película (en minutos): ");
                    int duracion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    System.out.print("Ingrese la sinopsis de la película: ");
                    String sinopsis = scanner.nextLine();

                    System.out.println("Ingrese el año del estreno");
                    int anoEstreno = scanner.nextInt();

                    System.out.println("Ingrese el mes del estreno");
                    int mesEstreno = scanner.nextInt();

                    System.out.println("Ingrese el día del estreno");
                    int diaEstreno = scanner.nextInt();

                    System.out.println("Ingrese la hora del estreno");
                    int horaEstreno= scanner.nextInt();

                    System.out.println("Ingrese la minuto del estreno");
                    int minutoEstreno = scanner.nextInt();

                    LocalDateTime fechaEstreno = LocalDateTime.of(anoEstreno,mesEstreno,diaEstreno,horaEstreno,minutoEstreno);
                    while(!cine.validarFechaValida(fechaEstreno)){
                        scanner.nextLine();
                        System.out.println("FECHA UBICADA EN EL PASADO");

                        System.out.println("Ingrese el año del estreno");
                        anoEstreno = scanner.nextInt();

                        System.out.println("Ingrese el mes del estreno");
                        mesEstreno = scanner.nextInt();

                        System.out.println("Ingrese el día del estreno");
                        diaEstreno = scanner.nextInt();

                        System.out.println("Ingrese la hora del estreno");
                        horaEstreno= scanner.nextInt();

                        System.out.println("Ingrese la minuto del estreno");
                        minutoEstreno = scanner.nextInt();
                        fechaEstreno = LocalDateTime.of(anoEstreno,mesEstreno,diaEstreno,horaEstreno,minutoEstreno);
                    }
                    Pelicula nuevaPelicula = new Pelicula(idPelicula, titulo, duracion, genero, clasificacion, sinopsis, autor, fechaEstreno);
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
                    System.out.println("HA ELEGIDO LA OPCION LISTAR PELICULAS");
                    cine.listarPeliculas();
                    break;
                case 4:
                    System.out.println("MODIFICAR CARTELERA");
                    cine.modificarCartelera();
                    break;
                case 5:
                    System.out.println("LISTAR CARTELERA");
                    cine.listarCartelera();
                    break;
                case 6:
                    System.out.println("AGREGAR COMIDA");
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.println("Ingrese el nombre de la nueva comida");
                    String nombreComida = scanner.nextLine();
                    String id = comida.generarIdComida(nombreComida);

                    System.out.println("Ingrese la descripcion");
                    String descripcion = scanner.nextLine();

                    System.out.println("Ingrese la categoría de la comida");
                    String categoria = scanner.nextLine();

                    System.out.println("Ingrese el tamaño de la comida");
                    String tamano = scanner.nextLine();

                    System.out.println("Ingrese el costo de la comida");
                    double costo = scanner.nextDouble();

                    TipoComida BoA = null;

                    while (BoA == null) {
                        System.out.println("Ingrese el tipo de comida (Bebida o Alimento)");
                        String tipo = scanner.nextLine();

                        if (tipo.equalsIgnoreCase("Bebida")) {
                            BoA = TipoComida.BEBIDA;
                        } else if (tipo.equalsIgnoreCase("Alimento")) {
                            BoA = TipoComida.COMIDA;
                        } else {
                            System.out.println("Ingrese un tipo de comida valido (Bebida o Alimento)");
                        }
                    }
                    Comida comida = new Comida(id, nombreComida,descripcion,categoria,tamano,costo,BoA);
                    // Registrar la comida usando gestionComida
                    cine.registrarComida(comida);
                    break;
                case 7:
                    scanner.nextLine();
                    System.out.println("MODIFICAR COMIDA");
                    System.out.println("Ingrese el nombre de la comida: ");
                    String nombreComida1 = scanner.nextLine();
                   cine.modificarComida(nombreComida1); // Implementar lógica para modificar comida
                    break;
                case 8:
                    System.out.println("LISTAR COMIDA");
                    cine.listarComida();
                    break;
                case 9:
                    System.out.println("CREAR SALA");
                    String idSala = cine.generarIdSalas();
                    Asientos [][] Asientos = new Asientos[12][10];
                    String filas = "ABCDEFGHIJKL";
                    int cantidadDeVip = 0;
                    int cantidadDePremium = 0;

                    for (int i = 0; i < 12; i++) { // filas
                        for (int j = 0; j < 10; j++) { // columnas
                            char letraUno = filas.charAt(i);
                            String numeroAsiento = letraUno + Integer.toString(j);

                            Asientos asiento;
                            if (i >= 0 && i <= 3) {
                                asiento = new Asientos(numeroAsiento, CalidadAsiento.VIP);
                                cantidadDeVip++;
                            } else {
                                asiento = new Asientos(numeroAsiento, CalidadAsiento.PREMIUM);
                                cantidadDePremium++;
                            }
                            // Almacenar el asiento en la matriz
                            Asientos[i][j] = asiento;
                        }
                    }
                    scanner.nextLine();
                    System.out.println("Ingrese el nombre de la pelicula: ");
                    String nombrePeliculaAValidar = scanner.nextLine();
                    while(!cine.validarNombrePelicula(nombrePeliculaAValidar)){
                        System.out.println("Nombre no encontrado");
                        System.out.println("Ingrese el nombre de la pelicula: ");
                        nombrePeliculaAValidar = scanner.nextLine();
                    }

                    Salas salas = new Salas(idSala,120,Asientos,cantidadDeVip,cantidadDePremium,nombrePeliculaAValidar);
                    cine.registrarSalas(salas);

                    break;

                    case 10:
                        System.out.println("LISTAR SALAS");
                        cine.listarSalas();
                        break;
                        case 11:
                            System.out.println("CREAR PROYECCION");

                            break;
                            case 12:
                                System.out.println("LISTAR PROYECCION");
                                break;
                                case 13:
                                    System.out.println("LISTAR CLIENTES");
                                    break;
                                    case 14:
                                        System.out.println("Saliendo del menu...");
                                        return;
                default:
                    System.out.println("Opción no válida. Por favor, elige nuevamente.");
            }
        }
    }

}

