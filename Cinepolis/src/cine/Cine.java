package cine;

import usuarios.cliente.Cliente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Cine {
    public ArrayList<Cliente> listaClientes = new ArrayList<>();
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
        int numeroAleatorio = random.nextInt(1, 3000);
        int diaActual = fecha.getDayOfMonth();
        String idCliente = String.format("C-%c%c-%d%d", letraUno, letraDos, numeroAleatorio, diaActual);
        return idCliente;

        //-----------
    }
}
