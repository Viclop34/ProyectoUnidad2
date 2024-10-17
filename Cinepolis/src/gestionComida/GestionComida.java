package gestionComida;

public class GestionComida {
    String comida;
    String comidaExistente;
    String descComida;
    Boolean precioComida;
    //constructor
    public GestionComida(String comida,
                         String comidaExistente,
                         String descComida,
                         Boolean precioComida) {
        this.comida = comida;
        this.comidaExistente = comidaExistente;
        this.descComida = descComida;
        this.precioComida = precioComida;
    }
    //Getters
    public String comida() {
        return comida;
    }
    public String comidaExistente() {
        return comidaExistente;
    }
    public String descComida() {
        return descComida;
    }
    public Boolean precioComida() {
        return precioComida;
    }

    //getters
    public String getComida() {
        return comida;
    }
    public String getComidaExistente() {
        return comidaExistente;
    }
    public String getDescComida() {
        return descComida;
    }
    public Boolean getPrecioComida () {
        return precioComida;
    }

    //setters
    public void setComida(String comida) {
        this.comida = comida;
    }
    public void setComidaExistente(String comidaExistente) {
        this.comidaExistente = comidaExistente;
    }
    public void setDescComida(String descComida) {
        this.descComida = descComida;
    }
    public void setPrecioComida(Boolean precioComida) {
        this.precioComida = precioComida;
    }

    //metodos
    public void mostrarComidaExistente() {
        System.out.println(comidaExistente);
        System.out.println("La comida existente es: " + comidaExistente);
    }

}