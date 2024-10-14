package cine;

import usuarios.cliente.Cliente;

import java.util.ArrayList;

public class Cine {
    public ArrayList<Cliente> listaClientes = new ArrayList<>();

    public void registrarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }
    public void listarClientes() {
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }
}
