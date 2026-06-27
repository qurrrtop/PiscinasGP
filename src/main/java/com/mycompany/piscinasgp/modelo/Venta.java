
package com.mycompany.piscinasgp.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Venta {
    private Long idVenta;
    private Cliente cliente;
    private EstadoVenta estadoVenta;
    private LocalDate fecha;
    private MetodoPago metodoPago;
    private String observacion;
    private BigDecimal total;
    private LocalDate fechaInicio;
    private LocalDate fechaCierre;

    public Venta() {
    }

    public Venta(Cliente cliente, EstadoVenta estadoVenta, LocalDate fecha, MetodoPago metodoPago, String observacion, BigDecimal total, LocalDate fechaInicio, LocalDate fechaCierre) {
        this.cliente = cliente;
        this.estadoVenta = estadoVenta;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.observacion = observacion;
        this.total = total;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
    }

    public Venta(Long idVenta, Cliente cliente, EstadoVenta estadoVenta, LocalDate fecha, MetodoPago metodoPago, String observacion, BigDecimal total, LocalDate fechaInicio, LocalDate fechaCierre) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.estadoVenta = estadoVenta;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.observacion = observacion;
        this.total = total;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public EstadoVenta getEstadoVenta() {
        return estadoVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public String getObservacion() {
        return observacion;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEstadoVenta(EstadoVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
    
    
    
    
}
