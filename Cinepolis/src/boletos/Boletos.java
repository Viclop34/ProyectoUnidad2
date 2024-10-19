package boletos;

import gestionPeliculas.Proyeccion;
import peliculas.Pelicula;
import salas.Salas;
import usuarios.cliente.Cliente;

public class Boletos {
String idBoleto;
String sala;
String asiento;
String cliente;
String pelicula;
String precio;
String tipoAsiento;
Boolean tieneDescuento;

    public Boletos(String idBoleto, String sala, String asiento, String cliente, String pelicula, String precio, String tipoAsiento, Boolean tieneDescuento) {
        this.idBoleto = idBoleto;
        this.sala = sala;
        this.asiento = asiento;
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.precio = precio;
        this.tipoAsiento = tipoAsiento;
        this.tieneDescuento = tieneDescuento;
    }

    //Getters

    public String getIdBoleto() {

        return idBoleto;
    }

    public String getSala() {
        return sala;
    }

    public String getAsiento() {
        return asiento;
    }

    public String getCliente() {
        return cliente;
    }

    public String getPelicula() {
        return pelicula;
    }

    public String getPrecio() {
        return precio;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public Boolean getTieneDescuento() {
        return tieneDescuento;
    }

    public void generarIdBoleto(Proyeccion proyeccion, Cliente cliente) {
        String nombre = cliente.getNombre();
        Salas numeroDeSala = proyeccion.getSala();
        Pelicula nombrePelicula = proyeccion.getPelicula();
    }
}
