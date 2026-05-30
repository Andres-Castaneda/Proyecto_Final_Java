package com.proyectorpg.model;

public class Arquero extends Personaje {
    public Arquero() {
        super();
    }

    public Arquero(int idPersonaje, String nombre, String clase, int nivel, float ataque, float defensa, float vida) {
        super(idPersonaje, nombre, clase, nivel, ataque, defensa, vida);
    }

    @Override
    public String habilidad() {
        return getNombre() + "Realizo el ataque final";
    }
    
}
