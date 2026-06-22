package com.mycompany.piscinasgp.modelo;

public class ClienteParticular {
    private String nombre;
    private String apellido;
    private String cuil;

    public ClienteParticular(String nombre, String apellido, String cuil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuil = cuil;
    }

    public ClienteParticular() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCuil() {
        return cuil;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }
    
    
}
