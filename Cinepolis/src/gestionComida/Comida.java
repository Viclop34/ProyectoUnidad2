package gestionComida;

public class Comida {
    //Comida
    int idComida;
    String nombreComida; //palomitas, cheetos,etc
    String descripcionComida;
    String tipoComida;
    String categoriaComida;
    String tamanoComida;
    Boolean precioComida;
    //Bebidas
    int idBebidas;
    String nombreBebida;
    String descripcionBebida;
    String tipoBebida;
    String categoriaBebida;
    String tamanoBebida;
    Boolean precioBebida;

    //constructor
    public Comida(int idComida,
                  String nombreComida,
                  String descripcionComida,
                  String tipoComida,
                  String categoriaComida,
                  String tamanoComida,
                  Boolean precio) {
        this.idComida = idComida;
        this.nombreComida = nombreComida;
        this.descripcionComida = descripcionComida;
        this.tipoComida = tipoComida;
        this.categoriaComida = categoriaComida;
        this.tamanoComida = tamanoComida;
        this.precioComida = precio;
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
    public String getTipoComida() {
        return tipoComida;
    }
    public String getCategoriaComida() {
        return categoriaComida;
    }
    public String getTamanoComida() {
        return tamanoComida;
    }
    public Boolean getPrecioComida() {
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
    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }
    public void setCategoriaComida(String categoriaComida) {
        this.categoriaComida = categoriaComida;
    }
    public void setTamanoComida(String tamanoComida) {
        this.tamanoComida = tamanoComida;
    }
    public void setPrecioComida(Boolean precioComida) {
        this.precioComida = precioComida;
    }

    //metodos
    public void mostrarInfoComida() {
        System.out.println("Comida: " + getIdComida());
        System.out.println("Nombre: " + getNombreComida());
        System.out.println("Descripcion: " + getDescripcionComida());
        System.out.println("Tipo: " + getTipoComida());
        System.out.println("Categoria: " + getCategoriaComida());
        System.out.println("Tamano: " + getTamanoComida());
        System.out.println("Precio: " + getPrecioComida());
    }
    public void mostrarComida() {
        System.out.println("Comida: " + getIdComida());
        System.out.println("Nombre: " + getNombreComida());
        System.out.println("Descripcion: " + getDescripcionComida());
        System.out.println("Tipo: " + getTipoComida());
        System.out.println("Categoria: " + getCategoriaComida());
        System.out.println("Tamano: " + getTamanoComida());
        System.out.println("Precio $ " + getPrecioComida());
    }
    public double calcularTotal(int cantidad){
        int i;
        i = cantidad * precioComida;
        return i;
    }
}
