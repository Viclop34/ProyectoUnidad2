package boletos;
public class Boletos {
String idBoleto;
String sala;
String asiento;
String cliente;
String pelicula;
double precio;
String tipoAsiento;
Boolean tieneDescuento;

    public Boletos(String idBoleto, String sala, String asiento, String cliente, String pelicula, double precio, String tipoAsiento, Boolean tieneDescuento) {
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

    public double getPrecio() {
        return precio;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public Boolean getTieneDescuento() {
        return tieneDescuento;
    }

    public String mostrarBoleto() {
        if (!tieneDescuento) {
            String datosBoletos = String.format("Id del boleto: %s,     Sala: %s,   Asiento: %s,    Cliente: %s,    " +
                            "Pelicula: %s,   Precio: %f.2    Tipo de Asiento: %s", idBoleto, sala, asiento,
                    cliente, pelicula, precio, tipoAsiento);
            return datosBoletos;
        }
        String datosBoletos = String.format("Id del boleto: %s,     Sala: %s,   Asiento: %s,    Cliente: %s," +
                "    Pelicula: %s,   Precio: %f.2    Tipo de Asiento: %s TIENE DESCUENTO", idBoleto,sala,asiento,
                cliente,pelicula,precio,tipoAsiento);
        return datosBoletos;
    }

}
