package com.mycompany.piscinasgp.modelo;
import com.mycompany.piscinasgp.modelo.Cliente;


public class ClienteEmpresa extends Cliente {
    private String razonSocial;
    private String nombreFantasia;
    private String rubro;
    private String cuit;

    public ClienteEmpresa() {
        super(); //constructor vacio cliente
    }

    public ClienteEmpresa(String razonSocial, String nombreFantasia, String rubro, String cuit, String email,
                          String telefono, String calleYnumero, String ciudad, String provincia, int codigoPostal,
                          String observaciones) {
        
        super(email, telefono, calleYnumero, ciudad, provincia, codigoPostal, observaciones);
        
        this.razonSocial = razonSocial;
        this.nombreFantasia = nombreFantasia;
        this.rubro = rubro;
        this.cuit = cuit;
    }
    
    public ClienteEmpresa(Long idCliente, String razonSocial, String nombreFantasia, String rubro, 
                             String cuit, String email, String telefono, String calleYnumero, 
                             String ciudad, String provincia, int codigoPostal, String observaciones) {
        
        // Enviamos todos los datos (incluido el ID) al constructor completo de la clase padre
        super(idCliente, email, telefono, calleYnumero, ciudad, provincia, codigoPostal, observaciones);
        
        this.razonSocial = razonSocial;
        this.nombreFantasia = nombreFantasia;
        this.rubro = rubro;
        this.cuit = cuit;
        
    }
    
    public String getRazonSocial() { return razonSocial; }

    public String getNombreFantasia() { return nombreFantasia; }

    public String getRubro() { return rubro; }

    public String getCuit() { return cuit; }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setNombreFantasia(String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    
    
}
