package gestionComida;

import resources.TipoComida;

public class Comida {
    //Comida
    int idComida;
    String nombreComida; //palomitas, cheetos,etc
    String descripcionComida;
    String categoriaComida;
    String tamanoComida;
    Double precioComida;
    TipoComida tipoComida;
    //constructor
    public Comida(int idComida,
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
   //Getters
    public int getIdComida() {
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
    public void setIdComida(int idComida) {
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
    public void mostrarInfoComida() {
        System.out.println("Comida: " + getIdComida());
        System.out.println("Nombre: " + getNombreComida());
        System.out.println("Descripcion: " + getDescripcionComida());
        System.out.println("Categoria: " + getCategoriaComida());
        System.out.println("Tamano: " + getTamanoComida());
        System.out.println("Precio: " + getPrecioComida());
    }
    public void mostrarComida() {
        System.out.println("Comida: " + getIdComida());
        System.out.println("Nombre: " + getNombreComida());
        System.out.println("Descripcion: " + getDescripcionComida());
        System.out.println("Categoria: " + getCategoriaComida());
        System.out.println("Tamano: " + getTamanoComida());
        System.out.println("Precio $ " + getPrecioComida());
    }
}
