package com.mycompany.piscinasgp.modelo;
import com.mycompany.piscinasgp.utils.Identifiable;



/**
 *
 * @author Mapatipi
 */


public class Cliente implements Identifiable{
    private Long idCliente;
    private String email;
    private String telefono;
    private String calleYnumero;
    private String ciudad;
    private String provincia;
    private int codigoPostal;
    private String observaciones;

    public Cliente() {       
    }

    public Cliente(String email, String telefono, String calleYnumero, String ciudad, String provincia, int codigoPostal, String observaciones) {
        setEmail(email);
        setTelefono (telefono);
        setCalleYnumero(calleYnumero);
        setCiudad(ciudad);
        setProvincia(provincia);
        setCodigoPostal(codigoPostal);
        setObservaciones(observaciones);
    }

    public Cliente(Long idCliente, String email, String telefono, String calleYnumero, String ciudad, String provincia, int codigoPostal, String observaciones) {
        this.idCliente = idCliente;
        this.email = email;
        this.telefono = telefono;
        this.calleYnumero = calleYnumero;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.codigoPostal = codigoPostal;
        this.observaciones = observaciones;
    }

    //getters
    @Override
    public Long getId() {
        return idCliente;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCalleYnumero() {
        return calleYnumero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public String getObservaciones() {
        return observaciones;
    }

    
    //setters
    
    
    public void setId(Long id) {
        if(idCliente != null && !idCliente.equals(0L)){
            throw new IllegalArgumentException ("el id ya fue asignado y no puede ser modificado");
        }
        if (id == null || id <= 0 ){
            throw new IllegalArgumentException ("el id no puede ser nulo / valor negativo");
        }
        this.idCliente = id;
    }

    public void setEmail(String email) {
        SetValidator.validate(email, StringFieldType.EMAIL);
        
        this.email = email;
    }

    public void setTelefono(String telefono) {
        SetValidator.validate(telefono, StringFieldType.TELEFONO);
        this.telefono = telefono;
    }

    public void setCalleYnumero(String calleYnumero) {
        SetValidator.validate(calleYnumero, StringFieldType.DIRECCION);
        this.calleYnumero = calleYnumero;
    }

    public void setCiudad(String ciudad) {
        SetValidator.validate(ciudad, StringFieldType.CIUDAD);
        this.ciudad = ciudad;
    }

    public void setProvincia(String provincia) {
        SetValidator.validate(provincia, StringFieldType.PROVINCIA);
        this.provincia = provincia;
    }

    public void setCodigoPostal(int codigoPostal) {
        SetValidator.validate(codigoPostal, NumericFieldType.CODIGO_POSTAL);
        
        this.codigoPostal = codigoPostal;
    }

    public void setObservaciones(String observaciones) {
        SetValidator.validate(observaciones, StringFieldType.OBSERVACIONES); //de observar amigo, pensala// 
        this.observaciones = observaciones;
    }
    
    
    
}
