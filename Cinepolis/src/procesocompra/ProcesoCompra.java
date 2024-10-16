package procesocompra;

public class ProcesoCompra {
    String IdProcesoCompra;
    String FechaCompra;
    Double PrecioCompra;
    String TipoPago;
    String boleto;

    public ProcesoCompra(String id, String fechaCompra, Double precioCompra, String tipoPago, String boleto) {
        this.IdProcesoCompra = id;
        this.FechaCompra = fechaCompra;
        this.PrecioCompra = precioCompra;
        this.TipoPago = tipoPago;
        this.boleto = boleto;
    }
   //Getters
    public String getId() {

        return IdProcesoCompra;
    }

    public String getFechaCompra() {

        return FechaCompra;
    }

    public Double getPrecioCompra() {

        return PrecioCompra;
    }

    public String getTipoPago() {

        return TipoPago;
    }

    public String getBoleto() {

        return boleto;
    }
    //Setters

    public void setId(String id) {

        IdProcesoCompra = id;
    }

    public void setFechaCompra(String fechaCompra) {

        FechaCompra = fechaCompra;
    }

    public void setPrecioCompra(Double precioCompra) {

        PrecioCompra = precioCompra;
    }

    public void setTipoPago(String tipoPago) {

        TipoPago = tipoPago;
    }

    public void setBoleto(String boleto) {

        this.boleto = boleto;
    }
}
