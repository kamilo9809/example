package Class;

import base.Persona;
import java.util.List;
import java.util.ArrayList;

public class Usuario extends Persona {

    List<Libro>librosPermitido;

    public Usuario(String nombre, String apellido) {
        super(nombre, apellido);
        this.librosPermitido = new ArrayList<>();
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Usuario: "+getNombre()+" "+getApellido());
    }

}
