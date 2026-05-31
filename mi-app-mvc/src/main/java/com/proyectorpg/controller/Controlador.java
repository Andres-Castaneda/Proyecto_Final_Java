package com.proyectorpg.controller;

import com.proyectorpg.model.Item;
import com.proyectorpg.model.Personaje;
import com.proyectorpg.model.dao.PersonajeDAO;
import java.util.List;

public class Controlador {
    private PersonajeDAO dao;

    public Controlador() {
        this.dao = new PersonajeDAO();
    }

    public void registrarPersonaje(Personaje p) {
        dao.insertar(p);
    }

    public List<Personaje> obtenerTodos() {
        return dao.listar();
    }
    public void eliminarPersonaje(int id) {
        Personaje p = dao.buscar(String.valueOf(id));
        if (p != null) {
            dao.eliminarPersonaje(id);
            System.out.println("Personaje eliminado con éxito.");
        } else {
            System.out.println("Error: El ID " + id + " no existe.");
        }
    }
    public void subirNivel(int id) {
        Personaje p = dao.buscar(String.valueOf(id));
        if (p != null) {
            p.subirNivel();
            dao.actualizarNivel(p);
            System.out.println("Nivel subido correctamente.");
        } else {
            System.out.println("Error: El ID " + id + " no existe.");
        }
    }
    public void equiparItem(int idPersonaje, String nombreItem) {
        Item item = new Item(0, nombreItem, 0, idPersonaje);
        dao.agregarItem(item);
        System.out.println("Ítem " + nombreItem + " equipado correctamente.");
    }
    /*public List<Item> obtenerInventario(int idPersonaje) {
        return dao.agregarItem(idPersonaje);
    }*/
}