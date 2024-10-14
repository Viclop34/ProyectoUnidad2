package boletos;

public class Boletos {
String IdBoleto;
String sala;
String Asiento;
String Cliente;
String Pelicula;
String Precio;
String TipoAsiento;
Boolean TieneDescuento;

    public Boletos(String idBoleto, String sala, String asiento, String cliente, String pelicula, String precio, String tipoAsiento, Boolean tieneDescuento) {
        IdBoleto = idBoleto;
        this.sala = sala;
        Asiento = asiento;
        Cliente = cliente;
        Pelicula = pelicula;
        Precio = precio;
        TipoAsiento = tipoAsiento;
        TieneDescuento = tieneDescuento;
    }
    //Getters

    public String getIdBoleto() {
        return IdBoleto;
    }

    public String getSala() {
        return sala;
    }

    public String getAsiento() {
        return Asiento;
    }

    public String getCliente() {
        return Cliente;
    }

    public String getPelicula() {
        return Pelicula;
    }

    public String getPrecio() {
        return Precio;
    }

    public String getTipoAsiento() {
        return TipoAsiento;
    }

    public Boolean getTieneDescuento() {
        return TieneDescuento;
    }
    //Setters

    public void setIdBoleto(String idBoleto) {
        IdBoleto = idBoleto;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void setAsiento(String asiento) {
        Asiento = asiento;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public void setPelicula(String pelicula) {
        Pelicula = pelicula;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public void setTipoAsiento(String tipoAsiento) {
        TipoAsiento = tipoAsiento;
    }

    public void setTieneDescuento(Boolean tieneDescuento) {
        TieneDescuento = tieneDescuento;
    }
}
