package asientos;

import resources.CalidadAsiento;
public class Asientos {
    String numeroAsiesnto;
    CalidadAsiento tipoAsiento;
    String status = "Desocupado";

    public Asientos(String numeroAsiesnto, CalidadAsiento tipoAsiento) {
        this.numeroAsiesnto = numeroAsiesnto;
        this.tipoAsiento = tipoAsiento;
    }

    public void mostrarInfo(){
        System.out.println("Numero de Asiento: " + numeroAsiesnto + "Tipo Asiento: " + tipoAsiento);
    }

    //Getters
    public String getNumeroAsiento() {
        return numeroAsiesnto;
    }

    public CalidadAsiento getTipoAsiento() {
        return tipoAsiento;
    }

    //Setters
    public void setNumeroAsiesnto(String numeroAsiesnto) {
        this.numeroAsiesnto = numeroAsiesnto;
    }

    public void setTipoAsiento(CalidadAsiento tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    //Verifica asiento ocupado
    public boolean estaOcupado() {
        return status.equalsIgnoreCase("Ocupado");
    }

    //Marca asiento como ocupado
    public void ocuparAsiento() {
        this.status = "Ocupado";
    }

}
