/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.piscinasgp.modelo;

/**
 *
 * @author Mapatipi
 */
public class MarcasProducto {
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

    public Long getIdMarca() {
        return idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    
}
