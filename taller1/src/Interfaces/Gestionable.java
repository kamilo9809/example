package Interfaces;

import Class.Libro;
import Class.Usuario;

public interface Gestionable {
    void prestarLibro(Usuario usuario, Libro libro);
    void devolverLibro(Usuario usuario, Libro libro);
}
