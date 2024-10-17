package menu;

import cine.Cine;
import gestionPeliculas.GestionPeliculas;
import peliculas.Pelicula;
import resources.Rol;
import usuarios.Usuarios;
import usuarios.admin.Admin;
import usuarios.cliente.Cliente;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Cine cine = new Cine();

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
                cine.validacionCurp(curpCliente);

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
                    

                    break;
                case 3:
                    // Implementar lógica para ver reservas
                    break;
                case 4:
                    // Implementar lógica para ver próximos estrenos
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
        while (opcion != 14) {
            System.out.println("\n*BIENVENIDO*");
            System.out.println("1. Registrar película");
            System.out.println("2. Modificar película");
            System.out.println("3. Registrar próximos estrenos");
            System.out.println("4. Modificar próximos estrenos");
            System.out.println("5. Agregar a cartelera");
            System.out.println("6. Eliminar de cartelera");
            System.out.println("14. Salir");

            System.out.print("\nSeleccione una opción:\n");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Implementar lógica de registrar película
                    break;
                case 2:
                    // Implementar lógica de modificar película
                    break;
                case 3:
                    // Implementar lógica de registrar próximos estrenos
                    break;
                case 4:
                    // Implementar lógica de modificar próximos estrenos
                    break;
                case 5:
                    // Implementar lógica de agregar a cartelera
                    break;
                case 6:
                    // Implementar lógica de eliminar de cartelera
                    break;
                case 14:
                    System.out.println("Hasta pronto.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
