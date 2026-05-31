package com.proyectorpg.view;

import com.proyectorpg.controller.Controlador;
import com.proyectorpg.model.Arquero;
import com.proyectorpg.model.Guerrero;
import com.proyectorpg.model.Mago;
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
            System.out.println("3. Eliminar Personaje");
            System.out.println("4. Subir Nivel");
            System.out.println("5. Equipar Ítem");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: listarPersonajes(); break;
                case 2: registrar(); break;
                case 3: eliminarPersonaje(); break;
                case 4: subirNivel(); break;
                //case 5: equiparItem(); break;
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
    private void registrar() {
        System.out.println("Ingrese el nombre:");
        String nombre = scanner.nextLine();
        
        System.out.println("Seleccione clase (1: Guerrero, 2: Mago, 3: Arquero):");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.println("Ingrese nivel, ataque, defensa y vida (separados por espacio):");
        int nivel = scanner.nextInt();
        float ataque = scanner.nextFloat();
        float defensa = scanner.nextFloat();
        float vida = scanner.nextFloat();
        scanner.nextLine();

        Personaje nuevo = null;
        // Creamos la instancia según la elección
        if (tipo == 1) nuevo = new Guerrero(0, nombre, "Guerrero", nivel, ataque, defensa, vida);
        else if (tipo == 2) nuevo = new Mago(0, nombre, "Mago", nivel, ataque, defensa, vida);
        else if (tipo == 3) nuevo = new Arquero(0, nombre, "Arquero", nivel, ataque, defensa, vida);

        if (nuevo != null) {
            controller.registrarPersonaje(nuevo);
            System.out.println("Personaje registrado con éxito.");
        } else {
            System.out.println("Tipo de personaje inválido.");
        }
    }
    public void eliminarPersonaje() {
        System.out.println("Ingrese el ID del personaje a eliminar:");
        int id = scanner.nextInt();
        controller.eliminarPersonaje(id);
    }
    public void subirNivel() {
        System.out.println("Ingrese el ID del personaje para subir de nivel:");
        int id = scanner.nextInt();
        controller.subirNivel(id);
    }
}
