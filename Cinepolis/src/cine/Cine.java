package cine;
import java.util.concurrent.ThreadLocalRandom;
import asientos.Asientos;
import resources.Rol;
import salas.Salas;
import usuarios.Usuarios;
import usuarios.cliente.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Cine {
    public ArrayList<Cliente> listaClientes = new ArrayList<>();
    public ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
    public String asientos [][] = new String [12][10];
    Random random = new Random();
    LocalDateTime fecha = LocalDateTime.now();

    public Usuarios validarInicioDeSesion (String idCliente, String contrasena) {
        for (Usuarios usuario : this.listaUsuarios) {
            if (usuario.getId().equals(idCliente) && usuario.getContrasena().equals(contrasena)) {
                return usuario;
            }
        }
        return null;
    }

    //METODOS RELACIONADOS CON CLIENTE
    public void registrarCliente(Cliente cliente) {
        listaClientes.add(cliente);
        listaUsuarios.add(cliente);
    }

    public void listarClientes() {
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    public String generarIdCliente(String nombreCliente, String apellidoCliente) {
        char letraUno = nombreCliente.charAt(0);
        char letraDos = apellidoCliente.charAt(apellidoCliente.length() - 1);
        int numeroAleatorio = ThreadLocalRandom.current().nextInt(1, 3000);
        int diaActual = fecha.getDayOfMonth();
        String idCliente = String.format("C-%c%c-%d%d", letraUno, letraDos, numeroAleatorio, diaActual);
        return idCliente;

    }

    public boolean confirmarMesCumpleanos(Cliente cliente) {
        int mesCumpleanos = cliente.getFechaNacimiento().getMonthValue();
        int mesActual = LocalDate.now().getMonthValue();

        if (mesCumpleanos == mesActual) {
            return true;
        }
        return false;
    }
    //-----------

    //METODOS RELACIONADOS CON ASIENTOS
    public void generarAsientos() {
        String filas = "ABCDEFGHIJKL";

        for (int i = 0; i < 12; i++) { //filas

            for (int j = 0; j < 10; j++) { //columnas

                char letraUno = filas.charAt(i);
                String numeroAsiento = letraUno + Integer.toString(j);

                if ( i >= 0 && i <= 3){
                    Asientos asiento = new Asientos(numeroAsiento, Rol.VIP);
                }
                else {
                    Asientos asiento = new Asientos(numeroAsiento, Rol.PREMIUM);
                }

            }
        }
    }

    public boolean precioTipoAsiento(Asientos asiento) {
        Rol rolValidar = asiento.getTipoAsiento();

        if (rolValidar == Rol.PREMIUM) {
            return true; // 200 Pesos
        }
        else {
            return false; // 400 Pesos
        }
    }

    //---------------

    // METODOS RELACIONADOS CON BOLETOS
    public String generarIdBoleto (Asientos asientos, Cliente cliente) {
        String asiento = asientos.getNumeroAsiesnto();
        String idCliente = cliente.getId();
        int numeroRandom = ThreadLocalRandom.current().nextInt(1, 3000);
        String idAsiento = String.format("%s-%s-%d", asiento, idCliente, numeroRandom);
        return idAsiento;
    }

    public void imprimirBoleto (String idBoleto, Asientos asientos, Cliente cliente, Salas salas) {
        double costo = 0;
        String asiento = asientos.getNumeroAsiesnto();
        String nombreCliente = cliente.getNombre();
        String tipoAsiento = asientos.getTipoAsiento().toString();
        String pelicula = salas.getPelicula();
        String idSala = salas.getIdSalas();

        if (precioTipoAsiento(asientos)){
        
            }
    }

    public boolean validacionCurp(String curp) {
        // Verificar si la longitud es correcta (18 caracteres)
        if (curp.length() != 18) {
            System.out.println("La CURP debe tener 18 caracteres.");
            return false;
        }
        // Validar los primeros 4 caracteres (deben ser letras mayúsculas)
        for (int i = 0; i < 4; i++) {
            char c = curp.charAt(i);
            if (!Character.isUpperCase(c)) {
                System.out.println("Los primeros 4 caracteres deben ser letras mayúsculas.");
                return false;
            }
        }
        // Validar los siguientes 6 caracteres (deben ser números para la fecha de nacimiento)
        for (int i = 4; i < 10; i++) {
            char c = curp.charAt(i);
            if (!Character.isDigit(c)) {
                System.out.println("La fecha de nacimiento debe contener solo dígitos.");
                return false;
            }
        }
        // Validar el carácter de sexo (H o M)
        char sexo = curp.charAt(10);
        if (sexo != 'H' && sexo != 'M') {
            System.out.println("El carácter de sexo debe ser 'H' para hombre o 'M' para mujer.");
            return false;
        }
        // Validar los siguientes 2 caracteres (estado, deben ser letras mayúsculas)
        for (int i = 11; i < 13; i++) {
            char c = curp.charAt(i);
            if (!Character.isUpperCase(c)) {
                System.out.println("El código de estado debe contener dos letras mayúsculas.");
                return false;
            }
        }
        // Validar los siguientes 3 caracteres (pueden ser letras o dígitos)
        for (int i = 13; i < 16; i++) {
            char c = curp.charAt(i);
            if (!Character.isUpperCase(c) && !Character.isDigit(c)) {
                System.out.println("Los caracteres del 13 al 15 deben ser letras mayúsculas o dígitos.");
                return false;
            }
        }
        // Validar el último carácter (debe ser un dígito)
        char digitoVerificador = curp.charAt(17);
        if (!Character.isDigit(digitoVerificador)) {
            System.out.println("El último carácter debe ser un dígito.");
            return false;
        }
        System.out.println("La CURP es válida.");
        return true;
    }
}
