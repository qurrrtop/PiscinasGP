package com.mycompany.piscinasgp.modelo;
import com.mycompany.piscinasgp.modelo.Cliente;


/**

 * * @author Mapatipi
 */
public class ClienteParticular extends Cliente {
    // Atributos ClienteParticular
    private String nombre;
    private String apellido;
    private String cuil;

   
    public ClienteParticular() {
        super(); // constructor vacio cliente
    }

    public ClienteParticular(String nombre, String apellido, String cuil, 
                             String email, String telefono, String calleYnumero, 
                             String ciudad, String provincia, int codigoPostal, String observaciones) {
        
        // carga datos comunes de la clase padre (Cliente)
        super(email, telefono, calleYnumero, ciudad, provincia, codigoPostal, observaciones);
        
        setNombre(nombre);
        setApellido(apellido);
        setCuil(cuil);
    }

    public ClienteParticular(Long idCliente, String nombre, String apellido, String cuil, 
                             String email, String telefono, String calleYnumero, 
                             String ciudad, String provincia, int codigoPostal, String observaciones) {
        
        // Enviamos todos los datos (incluido el ID) al constructor completo de la clase padre
        super(idCliente, email, telefono, calleYnumero, ciudad, provincia, codigoPostal, observaciones);
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuil = cuil;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    
     public String getCuil() {
        return cuil;
    }

     
    public String getApellido() {
        return apellido;
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