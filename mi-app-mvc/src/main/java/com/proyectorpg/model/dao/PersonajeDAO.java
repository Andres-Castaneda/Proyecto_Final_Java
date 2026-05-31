package com.proyectorpg.model.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.proyectorpg.model.Arquero;
import com.proyectorpg.model.Guerrero;
import com.proyectorpg.model.Item;
import com.proyectorpg.model.Mago;
import com.proyectorpg.model.Personaje;
import com.proyectorpg.model.database.Conexion;

public class PersonajeDAO {

    public Personaje mapearPersonaje(ResultSet rs) throws SQLException {
        String tipo = rs.getString("clase");

        if (tipo.equals("Guerrero")) {
            return new Guerrero(
                rs.getInt("idPersonaje"),
                rs.getString("Nombre"),
                tipo, rs.getInt("nivel"),
                rs.getFloat("ataque"),
                rs.getFloat("defensa"),
                rs.getFloat("vida")
            );
        } else if (tipo.equals("Mago")) {
            return new Mago(
                rs.getInt("idPersonaje"),
                rs.getString("Nombre"),
                tipo, rs.getInt("nivel"),
                rs.getFloat("ataque"),
                rs.getFloat("defensa"),
                rs.getFloat("vida")
            );
        } else if (tipo.equals("Arquero")) {
            return new Arquero(
                rs.getInt("idPersonaje"),
                rs.getString("Nombre"),
                tipo, rs.getInt("nivel"),
                rs.getFloat("ataque"),
                rs.getFloat("defensa"),
                rs.getFloat("vida")
            );
        } else {
            throw new SQLException("Tipo de personaje desconocido: " + tipo);
        }
    }

    public Personaje buscar(String id) {
        String sql = "SELECT * FROM Personaje WHERE idPersonaje = ?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapearPersonaje(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // En tu clase PersonajeDAO.java
    public void insertar(Personaje p) {
        String sql = "INSERT INTO Personaje (Nombre, clase, nivel, ataque, defensa, vida) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection con = Conexion.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getClass().getSimpleName());
            ps.setInt(3, p.getNivel());
            ps.setFloat(4, p.getAtaque());
            ps.setFloat(5, p.getDefensa());
            ps.setFloat(6, p.getVida());
            
            ps.executeUpdate();
            System.out.println("Personaje insertado correctamente en la BD.");
            
        } catch (SQLException e) {
            System.err.println("Error al insertar en la BD: " + e.getMessage());
        }
    }

    public List<Personaje> listar() {
        List<Personaje> lista = new ArrayList<>();
        String sql = "SELECT * FROM Personaje";

        try (Connection con = Conexion.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Personaje p = mapearPersonaje(rs);
                if (p != null) {
                    lista.add(p);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar personajes: " + e.getMessage());
        }
        return lista;
    }
    public void actualizarNivel(Personaje p) {
        String sql = "UPDATE Personaje SET nivel = ?, ataque = ?, defensa = ?, vida = ? WHERE idPersonaje = ?";
        
        try (Connection con = Conexion.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, p.getNivel());
            ps.setFloat(2, p.getAtaque());
            ps.setFloat(3, p.getDefensa());
            ps.setFloat(4, p.getVida());
            ps.setInt(5, p.getIdPersonaje());
            
            ps.executeUpdate();
            System.out.println("Personaje actualizado correctamente.");
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }
    public void eliminarPersonaje(int id) {
        String sql = "DELETE FROM Personaje WHERE idPersonaje = ?";
        
        try (Connection con = Conexion.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Personaje eliminado con éxito.");
            
        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }
    public void agregarItem(Item item) {
        String sql = "INSERT INTO Inventario (nombreItem, idPersonaje) VALUES (?, ?)";
        try (Connection con = Conexion.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, item.getNombreItem());
            ps.setInt(2, item.getIdPersonaje());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> obtenerInventario(int idPersonaje) {
        List<String> items = new ArrayList<>();
        String sql = "SELECT nombreItem FROM Inventario WHERE idPersonaje = ?";
        try (Connection con = Conexion.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPersonaje);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                items.add(rs.getString("nombreItem"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}