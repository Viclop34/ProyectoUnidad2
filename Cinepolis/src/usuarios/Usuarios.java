package usuarios;

import resources.Rol;

import java.time.LocalDate;

public class Usuarios {

    String idUsuario;
    String nombre;
    String apellidos;
    LocalDate fechaNacimiento;
    String contrasena;
    Rol rol;

    public Usuarios(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String contrasena, Rol rol ) {
        this.idUsuario = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasena = contrasena;
        this.rol = rol;
    }


    // Getters
    public String getId() {

        return idUsuario;
    }

    public String getNombre() {

        return nombre;
    }

    public String getApellidos() {

        return apellidos;
    }

    public LocalDate getFechaNacimiento() {

        return fechaNacimiento;
    }

    public String getContrasena() {

        return contrasena;
    }

    public Rol getRol() {

        return rol;
    }

    //Setters

    public void setId(String id) {

        this.idUsuario = id;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {

        this.apellidos = apellidos;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {

        this.fechaNacimiento = fechaNacimiento;
    }

    public void setContrasena(String contrasena) {

        this.contrasena = contrasena;
    }

    public void setRol(Rol rol) {

        this.rol = rol;
    }
}
