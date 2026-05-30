package com.proyectorpg.model;

public abstract class Personaje {
    private int idPersonaje;
    private String Nombre;
    private String clase;
    private int nivel;
    private float ataque;
    private float defensa;
    private float vida;

    public Personaje() {}

    // Constructor completo
    public Personaje(int idPersonaje, String nombre, String clase, int nivel, float ataque, float defensa, float vida) {
        this.idPersonaje = idPersonaje;
        this.Nombre = nombre;
        this.clase = clase;
        this.nivel = nivel;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vida = vida;
    }

    // Getters y Setters
    public int getIdPersonaje() {
        return idPersonaje;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getClase() {
        return clase;
    }

    public int getNivel() {
        return nivel;
    }

    public float getAtaque() {
        return ataque;
    }

    public float getDefensa() {
        return defensa;
    }

    public float getVida() {
        return vida;
    }

    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public void setNivel(int nivel) {
        if(nivel >= 0) this.nivel = nivel;
    }

    public void setAtaque(float ataque) {
        if(ataque >= 0) this.ataque = ataque;
    }

    public void setDefensa(float defensa) {
        if(defensa >= 0) this.defensa = defensa;
    }
    
    public void setVida(float vida) {
        if(vida >= 0) this.vida = vida;
    }

    public abstract String habilidad();
}
