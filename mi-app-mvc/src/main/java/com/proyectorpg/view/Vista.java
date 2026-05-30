package com.proyectorpg.view;

import com.proyectorpg.controller.Controlador;
import com.proyectorpg.model.Personaje;
import java.util.Scanner;

public class Vista {
    private Controlador controller;
    private Scanner scanner;

    public Vista() {
        this.controller = new Controlador();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("\n--- RPG Manager ---");
            System.out.println("1. Listar Personajes");
            System.out.println("2. Registrar Personaje");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: listarPersonajes(); break;
                case 6: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida.");
            }
        }
    }

    private void listarPersonajes() {
        for (Personaje p : controller.obtenerTodos()) {
            System.out.println("ID: " + p.getIdPersonaje() + " | Nombre: " + p.getNombre() + 
                               " | Clase: " + p.getClass().getSimpleName() + 
                               " | Habilidad: " + p.habilidad());
        }
    }
}
