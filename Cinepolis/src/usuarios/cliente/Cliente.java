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
        String datos = "Id: %s \nNombre: %s \nCurp: %s \nApellidos: %s \nFecha de Nacimiento: %s \nCurp: %s \n", id, nombre, apellidos, fechaNacimiento, curp;
        return datos;
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
