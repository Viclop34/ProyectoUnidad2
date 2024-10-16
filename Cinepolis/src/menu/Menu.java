package menu;

import cine.Cine;
import resources.Rol;
import usuarios.Usuarios;
import usuarios.admin.Admin;
import usuarios.cliente.Cliente;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Cine Cine= new Cine();

    public void login(){
        int intentosMaximos = 5, intentosUsuario =0;

        while(intentosUsuario < intentosMaximos){
            System.out.println("\n Bienvenido \n");
            System.out.println("¿Ya cuentas con cuenta cinepolis? Si/No");
            String respuesta = scanner.nextLine();
            if(respuesta == "Si" || respuesta == "SI"){

            System.out.println("Inicia sesión para continuar");
            System.out.println("Ingresa tu usuario: ");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa tu contraseña: ");
            String contrasenia = scanner.nextLine();

            Usuarios usuarioEnSesion= cine.validarInicioSesion(usuario, contrasenia);

            if(usuarioEnSesion instanceof Usuarios){
                //Sesion ha sido existosa
                 if(usuarioEnSesion.getRol() == Rol.CLIENTE){
                    //mostrar menu cliente
                    Cliente clienteEnSesion=(Cliente) usuarioEnSesion;
                    this.mostrarMenuCliente(clienteEnSesion);
                    intentosUsuario=0;
                }else{
                    Admin administradorEnSesion=(Admin)usuarioEnSesion;
                    this.mostrarMenuAdmin(administradorEnSesion);
                    intentosUsuario=0;
                }
            }
            else {
                intentosUsuario =mostrarErrorInicioSesion(intentosUsuario);
            }
          }
            else{
                System.out.println("Registrate!!");

                System.out.println("Ingresa tu nombre: ");
                String nombre = scanner.nextLine();
                System.out.println("Ingresa tus apellidos: ");
                String apellidos = scanner.nextLine();
                String id = Cine.generarIdCliente(nombre, apellidos);
                scanner.nextLine();

                System.out.println("Ingresa tu año de nacimiento: ");
                int anio = scanner.nextInt();
                System.out.println("Ingresa tu mes de nacimiento: ");
                int mes = scanner.nextInt();
                System.out.println("Ingresa tu dia de nacimiento: ");
                int dia = scanner.nextInt();

                LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
                scanner.nextLine();

                System.out.println("Ingrese el tipo de sangre del Paciente: ");
                String tipoSangre = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Ingrese la contraseña del paciente:");
                String contraseniaCliente = scanner.nextLine();
            }
        }
        System.out.println("Intentos maximos permitidos alcanzados.");
    }

    private int mostrarErrorInicioSesion(int intentosUsuario){
        System.out.println("Usuario o contraseña incorrectos, Intenta de nuevo");
        return intentosUsuario+1;
    }
    private void mostrarMenuCliente(Cliente clienteEnSesion){
        int opcion = 0;

        while(opcion != 2){
            System.out.println("** BIENVENI@ A CINEPOLIS WEB **");
            System.out.println("1. Comprar boletos");
            System.out.println("2. Ver peliculas de cartelera");
            System.out.println("3. Salir");
            System.out.println("Selecciona una opcion");
            opcion = scanner.nextInt();
            scanner.nextLine();


            switch (opcion){
                case 1:
                    System.out.print("Ingresa el ID del paciente: ");
                    String idPaciente = scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor seleccione de nuevo.");
            }
        }
    }

    private void mostrarMenuAdmin(Admin administradorEnSesion){
        int opcion = 0;
        while (opcion != 14) {
            System.out.println("\n*BIENVENIDO*");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Registrar Médico");
            System.out.println("3. Registrar Consultorio");
            System.out.println("4. Registrar Consultas");
            System.out.println("5. Mostrar Pacientes");
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
