package org.example.controllers;

import org.example.connection.DatabaseConnection;
import org.example.entities.Libro;
import org.example.entities.Prestamo;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PrestamoDao {
    private DatabaseConnection databaseConnection;

    public PrestamoDao(){
        this.databaseConnection = new DatabaseConnection();
    }

    //metodo para guardar datos nuevos
    public  void prestamoLibro(Prestamo prestamo){
        Transaction transaction = null;
        try(Session session = databaseConnection.getSession()){
            transaction = session.beginTransaction();
            session.save(prestamo);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    //metodo para obtener el prestamo por id
    public Libro prestamoLibroId(int id){
        try(Session session = databaseConnection.getSession()) {
            return session.get(Libro.class, id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    //metodo para obtener todos los prestamos
    public List<Prestamo> obtenerPrestamo(){
        try(Session session = databaseConnection.getSession()){
            return session.createQuery("FROM prestamo", Prestamo.class).list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //metodo para actualizar una prestamo
    public  void  actualizarLibro(Prestamo prestamo){
        Transaction transaction = null;
        try(Session session = databaseConnection.getSession()){
            transaction = session.beginTransaction();
            session.update(prestamo);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    //metodo para eliminar una Prestamo
    public  void eliminarLibro(int id){
        Transaction transaction = null;
        try(Session session = databaseConnection.getSession()){
            transaction = session.beginTransaction();
            Prestamo prestamo = session.get(Prestamo.class, id);
            if (prestamo != null){
                session.delete(prestamo);
                transaction.commit();
            }
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
