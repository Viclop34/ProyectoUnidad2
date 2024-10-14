package usuarios.admin;

import resources.Rol;
import usuarios.Usuarios;

import java.time.LocalDate;

public class Admin extends Usuarios {
    public Admin(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String contrasena, Rol rol) {
        super(id, nombre, apellidos, fechaNacimiento, contrasena, rol.ADMIN);
    }

}
