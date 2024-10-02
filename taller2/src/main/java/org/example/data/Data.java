package org.example.data;

import org.example.entities.Libro;
import org.example.entities.Persona;
import org.example.entities.Prestamo;
import org.example.entities.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Data {
    private SessionFactory sessionFactory;
    private boolean dataInit;

    public Data (){this.sessionFactory = new Configuration().configure().buildSessionFactory();}

    public void enterData() throws ParseException {
        if (dataInit){
            System.out.println("los datos ya han sido creados ya");
            return;
        }

        try{

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");

        //persona
        Persona persona1 = new Persona();
        persona1.setId(1);
        persona1.setNombre("luis");
        persona1.setApellido("rosania");
        persona1.setSexo("masculino");

        //usuario
        Usuario usuario1 = new Usuario();
        usuario1.setId(1);
        usuario1.setIdPersona(persona1);
        usuario1.setRol("Empleado");

        //libro
        Libro libro1 = new Libro();
        libro1.setId(1);
        libro1.setAutor("gabriel garcia marquez");
        libro1.setTitulo("cien anos de soledad");
        libro1.setIsbn("23");

        //prestamo
        Prestamo prestamo1 = new Prestamo();
        prestamo1.setId(1);
        prestamo1.setIdUsuario(usuario1);
        prestamo1.setIdLibro(libro1);
        prestamo1.setFechaPrestamo(formato.parse("2024-01-01"));
        prestamo1.setFechaDevolucion(formato.parse("0000-00-00"));
        prestamo1.setActivo(true);

        session.persist(persona1);
        session.persist(usuario1);
        session.persist(libro1);
        session.persist(prestamo1);

        session.getTransaction().commit();
        dataInit = true;
        System.out.println("Los datos han sido agregados correctamente");
        session.close();
        }catch (HibernateException error){
            System.out.println("el error es "+ error.getMessage());
        }
    }
}