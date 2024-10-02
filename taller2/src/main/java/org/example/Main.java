package org.example;

import org.example.connection.DatabaseConnection;
import org.example.controllers.PersonaDao;
import org.example.data.Data;
import org.example.entities.Persona;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        DatabaseConnection dbconnect = new DatabaseConnection();
        dbconnect.connectDb();
        Data addData = new Data();
        addData.enterData();

        Scanner scanner = new Scanner(System.in);

        System.out.println("ingrese los datos para crear la persona");
        Persona persona = new Persona();

        System.out.println("ingrese el nombre");
        String nombre = scanner.nextLine();
        persona.setNombre(nombre);
        System.out.println("ingrese el apellido");
        String apellido = scanner.nextLine();
        persona.setApellido(apellido);
        String sexo = scanner.nextLine();
        System.out.println("ingrese el sexo");
        persona.setSexo(sexo);

        PersonaDao personaDao = new PersonaDao();

    }
}