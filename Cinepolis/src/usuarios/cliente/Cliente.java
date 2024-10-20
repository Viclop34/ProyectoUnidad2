package usuarios.cliente;

import boletos.Boletos;
import resources.Rol;
import usuarios.Usuarios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Cliente extends Usuarios {
    String curp;
    String direccion;
    //RACW050729MMCSHNA2
    public Cliente(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String contrasena, String curp, String direccion) {
        super(id, nombre, apellidos, fechaNacimiento, contrasena, Rol.CLIENTE);
        this.curp = curp;
        this.direccion = direccion;
    }

    public String mostrarDatosCliente (){
        String datos = String.format("Id: %s  Nombre: %s  Apellidos: %s  Fecha de Nacimiento: %s  Curp: %s  Direccion: %s",getId(),getNombre() , getApellidos(),getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),curp,direccion);
        //getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
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

    private ArrayList<Boletos> boletosReservados;


    public void agregarBoleto(Boletos boleto) {
        this.boletosReservados.add(boleto);
    }

    public ArrayList<Boletos> getBoletosReservados() {
        return boletosReservados;
    }
}
