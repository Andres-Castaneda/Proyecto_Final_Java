package com.proyectorpg.controller;

import com.proyectorpg.model.Personaje;
import com.proyectorpg.model.dao.PersonajeDAO;
import java.util.List;

public class Controlador {
    private PersonajeDAO dao;

    public Controlador() {
        this.dao = new PersonajeDAO();
    }

    public void registrarPersonaje(Personaje p) {
        dao.insertar(p);;
    }

    public List<Personaje> obtenerTodos() {
        return dao.listar();
    }
}