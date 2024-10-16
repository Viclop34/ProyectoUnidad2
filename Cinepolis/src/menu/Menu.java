package menu;

import cine.Cine;
import resources.Rol;
import usuarios.Usuarios;
import usuarios.cliente.Cliente;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Cine Cine= new Cine();
    private final String USUARIO_ADMIN ="Leslye";
    private final String CONTRASENIA_ADMIN ="123456";

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

                if (usuario.equals(this.USUARIO_ADMIN) && contrasenia.equals(this.CONTRASENIA_ADMIN)) {
                    this.mostrarMenuAdmin();
                    return;
                }

                Usuarios usuarioEnSesion = Cine.validarInicioDeSesion(usuario, contrasenia);

                if (usuarioEnSesion != null) {
                    if (usuarioEnSesion.getRol() == Rol.CLIENTE) {
                        Cliente clienteEnSesion = (Cliente) usuarioEnSesion;
                        this.mostrarMenuCliente(clienteEnSesion);
                        return;
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

                String id = Cine.generarIdCliente(nombre, apellidos);

                System.out.println("Ingresa tu año de nacimiento: ");
                int anio = scanner.nextInt();
                System.out.println("Ingresa tu mes de nacimiento: ");
                int mes = scanner.nextInt();
                System.out.println("Ingresa tu día de nacimiento: ");
                int dia = scanner.nextInt();

                LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
                scanner.nextLine();

                System.out.println("Ingresa tu CURP: ");
                String curpCliente = scanner.nextLine();
                Cine.validacionCurp(curpCliente);

                System.out.println("Ingresa tu dirección:");
                String direccionCliente = scanner.nextLine();

                System.out.println("Crea tu contraseña:");
                String contraseniaCliente = scanner.nextLine();
             Cliente cliente = new Cliente(id,nombre,apellidos,fechaNacimiento,curpCliente,direccionCliente,contraseniaCliente);
              Cine.registrarCliente(cliente);
                System.out.println("Registro exitoso!");
            }
        }
        System.out.println("Intentos máximos permitidos alcanzados.");
    }


    private int mostrarErrorInicioSesion(int intentosUsuario){
        System.out.println("Usuario o contraseña incorrectos, Intenta de nuevo");
        return intentosUsuario+1;
    }
    private void mostrarMenuCliente(Cliente clienteEnSesion){
        int opcion = 0;

        while(opcion != 5){
            System.out.println("** BIENVENI@ A CINEPOLIS **");
            System.out.println("1. Comprar boletos");
            System.out.println("2. Ver peliculas de cartelera");
            System.out.println("3. Ver mis reservas");
            System.out.println("4. Ver proximos estrenos");
            System.out.println("5. Salir");
            System.out.println("Selecciona una opcion");
            opcion = scanner.nextInt();
            scanner.nextLine();


            switch (opcion){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
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

    private void mostrarMenuAdmin(){
        int opcion = 0;
        while (opcion != 14) {
            System.out.println("\n*BIENVENIDO*");
            System.out.println("1. Registrar pelicula");
            System.out.println("2. Modificar pelicula");
            System.out.println("3. Registrar proximos estrenos");
            System.out.println("4. Modificar proximos estrenos");
            System.out.println("5. Agregar a cartelera");
            System.out.println("6. Agregar a cartelera");
            System.out.println("7. Eliminar de cartelera");
            System.out.println("8. ");
            System.out.println("14.Salir");

            System.out.print("\nSeleccione una opción:\n");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                   break;
                case 2:
                   break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }
    }
}
