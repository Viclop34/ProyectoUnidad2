package usuarios.cliente;

import resources.Rol;
import usuarios.Usuarios;

import java.time.LocalDate;

public class Cliente extends Usuarios {
    String curp;
    String direccion;
    public Cliente(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String contrasena, String curp, String direccion) {
        super(id, nombre, apellidos, fechaNacimiento, contrasena, Rol.CLIENTE);
        this.curp = curp;
        this.direccion = direccion;
    }

    public String mostrarDatosCliente (){
        String datos = "Id: %s \nNombre: %s \nApellidos: %s \nFecha de Nacimiento: %s \nCurp: %s \nDireccion: %s", id, nombre, apellidos, fechaNacimiento, curp, direccion;
        return datos;
    }
    //Getters
    public String getCurp() {

        return curp;
    }

    public String getDireccion() {
        return direccion;
    }

    //Setters
    public void setCurp(String curp) {

        this.curp = curp;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
