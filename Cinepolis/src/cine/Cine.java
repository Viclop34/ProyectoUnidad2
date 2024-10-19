package cine;

import asientos.Asientos;
import gestionPeliculas.GestionPeliculas;
import peliculas.Pelicula;
import resources.CalidadAsiento;
import salas.Salas;
import usuarios.Usuarios;
import usuarios.admin.Admin;
import usuarios.cliente.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class Cine {
    public ArrayList<Cliente> listaClientes = new ArrayList<>();
    public ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
    public ArrayList<Admin> listaAdmin = new ArrayList<>();
    public Scanner scanner = new Scanner(System.in);
    public ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
    public ArrayList<Pelicula> carteleraActual = new ArrayList<>();


    private GestionPeliculas gestionPeliculas = new GestionPeliculas();

    public String asientos[][] = new String[12][10];
    Random random = new Random();
    LocalDateTime fecha = LocalDateTime.now();

    public Usuarios validarInicioDeSesion(String idUsuario, String contrasena) {
        for (Usuarios usuario : this.listaUsuarios) {
            if (usuario.getId().equals(idUsuario) && usuario.getContrasena().equals(contrasena)) {
                return usuario;
            }
        }
        return null;
    }

    // MÉTODOS RELACIONADOS CON CLIENTE
    public void registrarCliente(Cliente cliente) {
        listaClientes.add(cliente);
        listaUsuarios.add(cliente);
    }

    public void listarClientes() {
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.mostrarDatosCliente());
        }
    }

    public void listarCartelera() {
        for (Pelicula pelicula : carteleraActual) {}
    }

    public void listarPeliculas() {
        if (listaPeliculas.isEmpty()) {
            System.out.println("No hay películas registradas.");
        } else {
            for (Pelicula pelicula : listaPeliculas) {
                System.out.println(pelicula.mostrarDatosPeliculas());
            }
        }
    }


    public String generarIdCliente(String nombreCliente, String apellidoCliente) {
        char letraUno = nombreCliente.charAt(0);
        char letraDos = apellidoCliente.charAt(apellidoCliente.length() - 1);
        int numeroAleatorio = ThreadLocalRandom.current().nextInt(1, 3000);
        int diaActual = fecha.getDayOfMonth();
        return String.format("C-%c%c-%d%d", letraUno, letraDos, numeroAleatorio, diaActual);
    }

    public boolean confirmarMesCumpleanos(Cliente cliente) {
        int mesCumpleanos = cliente.getFechaNacimiento().getMonthValue();
        int mesActual = LocalDate.now().getMonthValue();

        if (mesCumpleanos == mesActual) {
            return true;
        }
        return false;
    }

    // MÉTODOS RELACIONADOS CON ASIENTOS
    public void generarAsientos() {
        String filas = "ABCDEFGHIJKL";

        for (int i = 0; i < 12; i++) { // filas
            for (int j = 0; j < 10; j++) { // columnas
                char letraUno = filas.charAt(i);
                String numeroAsiento = letraUno + Integer.toString(j);

                Asientos asiento;
                if (i >= 0 && i <= 3) {
                    asiento = new Asientos(numeroAsiento, CalidadAsiento.VIP);
                } else {
                    asiento = new Asientos(numeroAsiento, CalidadAsiento.PREMIUM);
                }
                // Almacenar el asiento en la matriz
                this.asientos[i][j] = numeroAsiento;
            }
        }
    }

    public boolean precioTipoAsiento(Asientos asiento) {
        CalidadAsiento calidadValidar = asiento.getTipoAsiento();

        if (calidadValidar == CalidadAsiento.PREMIUM) {
            return true; // 200 Pesos
        }
        else {
            return false; // 400 Pesos
        }
    }

    // MÉTODOS RELACIONADOS CON BOLETOS
    public String generarIdBoleto(Asientos asientos, Cliente cliente) {
        String asiento = asientos.getNumeroAsiento(); // Corregido
        String idCliente = cliente.getId();
        int numeroRandom = ThreadLocalRandom.current().nextInt(1, 3000);
        return String.format("%s-%s-%d", asiento, idCliente, numeroRandom);
    }

    public void imprimirBoleto(String idBoleto, Asientos asientos, Cliente cliente, Salas salas) {
        double costo = precioTipoAsiento(asientos) ? 200 : 400; // Definir el costo
        String asiento = asientos.getNumeroAsiento(); // Corregido
        String nombreCliente = cliente.getNombre();
        String tipoAsiento = asientos.getTipoAsiento().toString();
        String pelicula = salas.getPelicula();
        String idSala = salas.getIdSalas();

        System.out.printf("Boleto: %s\nCliente: %s\nAsiento: %s\nTipo Asiento: %s\nPelicula: %s\nSala: %s\nCosto: %.2f\n",
                idBoleto, nombreCliente, asiento, tipoAsiento, pelicula, idSala, costo);
    }

    public boolean validacionCurp(String curp) {
        if (curp.length() != 18) {
            System.out.println("La CURP debe tener 18 caracteres.");
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (!Character.isUpperCase(curp.charAt(i))) {
                System.out.println("Los primeros 4 caracteres deben ser letras mayúsculas.");
                return false;
            }
        }
        for (int i = 4; i < 10; i++) {
            if (!Character.isDigit(curp.charAt(i))) {
                System.out.println("La fecha de nacimiento debe contener solo dígitos.");
                return false;
            }
        }
        char sexo = curp.charAt(10);
        if (sexo != 'H' && sexo != 'M') {
            System.out.println("El carácter de sexo debe ser 'H' para hombre o 'M' para mujer.");
            return false;
        }
        for (int i = 11; i < 13; i++) {
            if (!Character.isUpperCase(curp.charAt(i))) {
                System.out.println("El código de estado debe contener dos letras mayúsculas.");
                return false;
            }
        }
        for (int i = 13; i < 16; i++) {
            char c = curp.charAt(i);
            if (!Character.isUpperCase(c) && !Character.isDigit(c)) {
                System.out.println("Los caracteres del 13 al 15 deben ser letras mayúsculas o dígitos.");
                return false;
            }
        }
        if (!Character.isDigit(curp.charAt(17))) {
            System.out.println("El último carácter debe ser un dígito.");
            return false;
        }
        System.out.println("La CURP es válida.");
        return true;
    }

    public void registrarAdmin (Admin admin) {
        this.listaAdmin.add(admin);
        this.listaUsuarios.add(admin);
    }
    public Cine (){
        LocalDate fechaDeNacimiento = LocalDate.of(2005,03,22);
        Admin administrador= new Admin("Admin1","Mariana", "Herrejon",fechaDeNacimiento,"123");
        registrarAdmin(administrador);
        this.listaUsuarios.add(administrador);
        this.listaAdmin.add(administrador);
    }
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
                System.out.println("\n Modificar película: " + titulo);

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


    // Agregar película a cartelera
    public void agregarACartelera(Pelicula pelicula) {
        carteleraActual.add(pelicula);
        System.out.println("Película '" + pelicula.getTitulo() + "' agregada a cartelera.");
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
                        break;

                    case 2: // Eliminar película
                        System.out.print("¿Está seguro de que desea eliminar la película? (s/n): ");
                        String confirmacion = scanner.nextLine();
                        if (confirmacion.equalsIgnoreCase("s")) {
                            carteleraActual.remove(pelicula);
                            listaPeliculas.remove(pelicula);

                            System.out.println("Película eliminada de la cartelera.");
                        } else {
                            System.out.println("Eliminación cancelada.");
                        }
                        break;

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

    public boolean validarFechaValida (LocalDateTime fecha) {
        LocalDateTime fechaActual = LocalDateTime.now();
        if (fecha.isBefore(fechaActual)){
            return false;
        }
        return true;
    }



}

