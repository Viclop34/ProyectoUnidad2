package cine;

import asientos.Asientos;
import boletos.Boletos;
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
    public ArrayList<Boletos> listaBoletos = new ArrayList<>();
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
        int numeroAleatorio = random.nextInt(1, 3000);
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

    public boolean validarDescuento(Asientos asiento, Cliente cliente) {

    }
    //---------------

    // METODOS RELACIONADOS CON BOLETOS
    public String generarIdBoleto (Asientos asientos, Cliente cliente) {
        String asiento = asientos.getNumeroAsiento();
        String idCliente = cliente.getId();
        int numeroRandom = random.nextInt(1, 3000);
        String idAsiento = String.format("%s-%s-%d", asiento, idCliente, numeroRandom);
        return idAsiento;
    }

    public void registrarBoleto(Boletos boleto) {
        listaBoletos.add(boleto);
        // Se debe registrar en una sala
    }


    public void imprimirBoleto (String idBoleto, Asientos asientos, Cliente cliente, Salas salas) {

    }

}
