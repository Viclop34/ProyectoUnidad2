package usuarios.cliente;

import resources.Rol;
import usuarios.Usuarios;

import java.time.LocalDate;

public class Cliente extends Usuarios {
    String curp;
    public Cliente(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String contrasena, Rol rol, String curp) {
        super(id, nombre, apellidos, fechaNacimiento, contrasena, rol.CLIENTE);
        this.curp = curp;
    }

    public String mostrarDatosCliente (){
        String datos = "Id: %s \nNombre: %s \n "
    }
    //Getters
    public String getCurp() {
        return curp;
    }

    //Setters
    public void setCurp(String curp) {
        this.curp = curp;
    }
}
