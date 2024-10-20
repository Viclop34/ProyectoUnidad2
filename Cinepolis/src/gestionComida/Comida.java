package gestionComida;

import resources.TipoComida;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Comida {
    //Comida
    String idComida;
    String nombreComida; //palomitas, cheetos,etc
    String descripcionComida;
    String categoriaComida;
    String tamanoComida;
    Double precioComida;
    TipoComida tipoComida;
    LocalDateTime fecha = LocalDateTime.now();
    //constructor
    public Comida(String idComida,
                  String nombreComida,
                  String descripcionComida,
                  String categoriaComida,
                  String tamanoComida,
                  Double precio, TipoComida tipoComida) {
        this.idComida = idComida;
        this.nombreComida = nombreComida;
        this.descripcionComida = descripcionComida;
        this.categoriaComida = categoriaComida;
        this.tamanoComida = tamanoComida;
        this.precioComida = precio;
        this.tipoComida = tipoComida;
    }
    public Comida() {
    }
   //Getters
    public String getIdComida() {
        return idComida;
    }
    public String getNombreComida() {
        return nombreComida;
    }
    public String getDescripcionComida() {
        return descripcionComida;
    }

    public String getCategoriaComida() {
        return categoriaComida;
    }
    public String getTamanoComida() {
        return tamanoComida;
    }
    public Double getPrecioComida() {
        return precioComida;
    }

    //setters
    public void setIdComida(String idComida) {
        this.idComida = idComida;
    }
    public void setNombreComida(String nombreComida) {
        this.nombreComida = nombreComida;
    }
    public void setDescripcionComida(String descripcionComida) {
        this.descripcionComida = descripcionComida;
    }
    public void setCategoriaComida(String categoriaComida) {
        this.categoriaComida = categoriaComida;
    }
    public void setTamanoComida(String tamanoComida) {
        this.tamanoComida = tamanoComida;
    }
    public void setPrecioComida(Double precioComida) {
        this.precioComida = precioComida;
    }

    //metodos
    public String mostrarInfoComida() {
        String datos = String.format("Id: %s    ,Nombre: %s,    Descripcion: %s,    Categoria: %s,  Tamano: %s,  Precio: %.2f", idComida,nombreComida,descripcionComida,categoriaComida,tamanoComida,precioComida);
        return datos;
    }
    private Set<String> idsGeneradosComida = new HashSet<>();
    private LocalDate fecha1 = LocalDate.now(); // Asumimos que esta fecha ya está inicializada

    public String generarIdComida(String nombreComida) {
        char letraUno = nombreComida.charAt(0);
        int numeroAleatorio = ThreadLocalRandom.current().nextInt(1, 3000);
        int diaActual = fecha.getDayOfMonth();

        String idComida = String.format("C-%c%d-%d", letraUno, numeroAleatorio, diaActual);

        // Validar si el ID ya fue generado
        while (idsGeneradosComida.contains(idComida)) {
            numeroAleatorio = ThreadLocalRandom.current().nextInt(1, 3000);  // Generamos un nuevo número aleatorio
            idComida = String.format("C-%c%d-%d", letraUno, numeroAleatorio, diaActual);
        }

        idsGeneradosComida.add(idComida);  // Guardamos el nuevo ID
        return idComida;
    }
}
