/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.piscinasgp.modelo;
import com.mycompany.piscinasgp.utils.Identifiable;

/**
 *
 * @author Mapatipi
 */
public class MarcasProducto implements Identifiable{
private Long idMarca;
private String nombre;

    public MarcasProducto() {
    }

    public MarcasProducto(String nombre) {
        this.nombre = nombre;
    }

    public MarcasProducto(Long idMarca, String nombre) {
        this.idMarca = idMarca;
        this.nombre = nombre;
    }
    
    @Override
    public Long getId() {
        return idMarca;
    }

    public String getNombre() {
        return nombre;
    }
    @Override
    public void setId(Long id) {
        this.idMarca = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    
}
