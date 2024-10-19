package cine;

import asientos.Asientos;
import gestionComida.Comida;
import gestionPeliculas.Proyeccion;
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
    public ArrayList<Comida> listaComida = new ArrayList<>();
    ArrayList<Proyeccion> listaProyecciones= new ArrayList<>();
    public ArrayList<Salas> listaSalas= new ArrayList<>();


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
        for (Pelicula pelicula : carteleraActual) {
            System.out.println(pelicula.mostrarDatosPeliculas());
        }
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
                pelicula.setDuracion(scanner.nextInt());

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
        Pelicula pelicula = null;

        // Buscar la película por su ID
        for (Pelicula peliculaEnLista : listaPeliculas) {
            if (peliculaEnLista.getIdPelicula().equals(idPelicula)) {
                pelicula = peliculaEnLista;
            }
        }

        if (pelicula == null) {
            System.out.println("No se encontró ninguna película con el ID especificado.");
            return;
        }

        System.out.println("\n¿Qué desea hacer con esta película?");
        System.out.println("1. Modificar detalles");
        System.out.println("2. Eliminar película");
        System.out.println("3. Cancelar");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        switch (opcion) {
            case 1: // Modificar detalles
                // Modificar detalles
                scanner.nextLine();
                System.out.print("Ingrese el nuevo título (o presione Enter para mantenerlo): ");
                String nuevoTitulo = scanner.nextLine();
                if (!nuevoTitulo.isEmpty()) {
                    pelicula.setTitulo(nuevoTitulo);
                }
                scanner.nextLine();
                System.out.print("Ingrese la nueva duración (o presione Enter para mantenerla): ");
                int nuevaDuracion = scanner.nextInt();
                    pelicula.setDuracion(nuevaDuracion);

                scanner.nextLine();
                System.out.print("Ingrese el nuevo género (o presione Enter para mantenerlo): ");
                String nuevoGenero = scanner.nextLine();
                if (!nuevoGenero.isEmpty()) {
                    pelicula.setGenero(nuevoGenero);
                }

                scanner.nextLine();
                System.out.print("Ingrese la nueva clasificación (o presione Enter para mantenerla): ");
                String nuevaClasificacion = scanner.nextLine();
                if (!nuevaClasificacion.isEmpty()) {
                    pelicula.setClasificacion(nuevaClasificacion);
                }

                scanner.nextLine();
                System.out.print("Ingrese la nueva sinopsis (o presione Enter para mantenerla): ");
                String nuevaSinopsis = scanner.nextLine();
                if (!nuevaSinopsis.isEmpty()) {
                    pelicula.setSinopsis(nuevaSinopsis);
                }

                scanner.nextLine();
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
                    int indexPelicula = 0;
                    for (Pelicula peliculaEnCartelera : carteleraActual) {
                        if (peliculaEnCartelera.getIdPelicula().equals(idPelicula)){
                            carteleraActual.remove(indexPelicula);
                            break;
                        }
                        indexPelicula++;
                    }
                    indexPelicula = 0;
                    for (Pelicula peliculaEnLista : listaPeliculas) {
                        if (peliculaEnLista.getIdPelicula().equals(idPelicula)){
                            listaPeliculas.remove(indexPelicula);
                            break;
                        }
                        indexPelicula++;
                    }


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

    public boolean validarFechaValida (LocalDateTime fecha) {
        LocalDateTime fechaActual = LocalDateTime.now();
        if (fecha.isBefore(fechaActual)){
            return false;
        }
        return true;
    }

    public void registrarComida(Comida comida) {
        listaComida.add(comida);
    }

    public void modificarComida(String nombreComida) {
        Scanner sc = new Scanner(System.in);
        Comida comida = null;
        for (Comida comidaEnLista : listaComida) {
            if (comidaEnLista.getNombreComida().equals(nombreComida)) {
                comida = comidaEnLista;
            }
        }
        if (comida == null) {
            System.out.println("El comida no existe");
        }
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("Ingrese la opcion deseada: ");
            System.out.println("1.Eliminar comida ");
            System.out.println("2.Modificar precio ");
            System.out.println("3.Salir ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println(" Haz elegido la opcion eliminar comida ");
                    int indexComida = 0;
                    for (Comida comidaEnLista : listaComida) {
                        if (comidaEnLista.getNombreComida().equals(nombreComida)) {
                            listaComida.remove(indexComida);
                            break;
                        }
                        indexComida++;
                    }
                    System.out.println("La comida ha sido eliminada correctamente ");
                    break;
                case 2:
                    System.out.println("Haz elegido la opcion modificar precio ");
                    System.out.println("Ingrese el nuevo precio: ");
                    Double precio = sc.nextDouble();
                    for(Comida comida1 : listaComida) {
                        if (comida1.getNombreComida().equals(nombreComida)) {
                            comida1.setPrecioComida(precio);
                        }
                    }
                    System.out.println("La comida ha sido modificada correctamente ");
                    break;
                case 3:
                    return;
            }
        }
    }

    public void listarComida(){
        for (Comida comida: listaComida){
            System.out.println(comida.mostrarInfoComida());
        }
    }

/*    public void agregarProyeccion(Proyeccion proyeccion) {
        listaProyecciones.add(proyeccion);
    }

    public void agregarProyeccion(int idSalas, Pelicula pelicula, LocalDate horario) {
        for (Salas salas : listaSalas) {
            if (salas.getIdSalas().equals(idSalas)) {
                Proyeccion proyeccion = new Proyeccion(pelicula, horario,salas);
                salas.agregarProyeccion(proyeccion);
                System.out.println("Proyección de '" + pelicula.getTitulo() + "' agregada a la sala " + idSalas + " a las " + horario + ".");
                return;
            }
        }
        System.out.println("La sala " + idSalas + " no existe.");
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
    }*/
    public String generarIdSalas() {
        int diaActual = LocalDate.now().getDayOfMonth();
        int numeroAleatorio = new Random().nextInt(100000 - 50) + 50;
        return String.format("CO-%d-%d-%d", listaSalas.size() + 1, numeroAleatorio, diaActual);
    }
    public void registrarSalas(Salas salas) {

        listaSalas.add(salas);
        System.out.println("Sala agregada exitosamente.");

    }
    public void listarSalas(){
        for(Salas sala : listaSalas){
            System.out.println(sala.mostrarDatosSala());
        }
    }

    public boolean validarNombrePelicula(String nombrePelicula) {
        for(Pelicula pelicula : listaPeliculas) {
            if(pelicula.getTitulo().equals(nombrePelicula)) {
                return true;
            }
        }
        return false;
    }

}

