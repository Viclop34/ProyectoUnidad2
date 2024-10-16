package cine;
import java.util.concurrent.ThreadLocalRandom;
import asientos.Asientos;
import resources.Rol;
import usuarios.cliente.Cliente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Cine {
    public ArrayList<Cliente> listaClientes = new ArrayList<>();
    public String asientos [][] = new String [12][10];
    Random random = new Random();
    LocalDateTime fecha = LocalDateTime.now();

    //METODOS RELACIONADOS CON CLIENTE
    public void registrarCliente(Cliente cliente) {
        listaClientes.add(cliente);
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

        //-----------
    }

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

    //---------------
}
