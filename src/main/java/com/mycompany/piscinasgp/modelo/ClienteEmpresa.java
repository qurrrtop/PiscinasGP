package com.mycompany.piscinasgp.modelo;

public class ClienteEmpresa {
    private String razonSocial;
    private String nombreFantasia;
    private String rubro;
    private String cuit;

    public ClienteEmpresa() {
    }

    public ClienteEmpresa(String razonSocial, String nombreFantasia, String rubro, String cuit) {
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
