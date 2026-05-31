package com.proyectorpg.model;

public class Item {
    private int idItem;
    private String nombreItem;
    private int bonus;
    private int idPersonaje;

    public Item() {}

    public Item(int idItem, String nombreItem, int bonus, int idPersonaje) {
        this.idItem = idItem;
        this.nombreItem = nombreItem;
        this.bonus = bonus;
        this.idPersonaje = idPersonaje;
    }
    public int getIdItem() {
        return idItem;
    }
    public String getNombreItem() {
        return nombreItem;
    }
    public int getBonus() {
        return bonus;
    }
    public int getIdPersonaje() {
        return idPersonaje;
    }
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }
    
}