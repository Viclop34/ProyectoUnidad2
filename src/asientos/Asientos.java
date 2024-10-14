package asientos;

import resources.Rol;

public class Asientos {
    String numeroAsiesnto;
    Rol tipoAsiento;

    public Asientos(String numeroAsiesnto, Rol tipoAsiento) {
        this.numeroAsiesnto = numeroAsiesnto;
        this.tipoAsiento = tipoAsiento;
    }

    //Getters
    public String getNumeroAsiesnto() {
        return numeroAsiesnto;
    }

    public Rol getTipoAsiento() {
        return tipoAsiento;
    }

    //Setters
    public void setNumeroAsiesnto(String numeroAsiesnto) {
        this.numeroAsiesnto = numeroAsiesnto;
    }

    public void setTipoAsiento(Rol tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }
}
