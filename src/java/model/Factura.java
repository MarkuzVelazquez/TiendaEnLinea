package model;
// Generated 24/05/2019 03:33:36 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Factura generated by hbm2java
 */
public class Factura  implements java.io.Serializable {


     private int numFactura;
     private Cliente cliente;
     private Double total;
     private Date fecha;
     private Set<Envio> envios = new HashSet<Envio>(0);

    public Factura() {
    }

	
    public Factura(int numFactura) {
        this.numFactura = numFactura;
    }
    public Factura(int numFactura, Cliente cliente, Double total, Date fecha, Set<Envio> envios) {
       this.numFactura = numFactura;
       this.cliente = cliente;
       this.total = total;
       this.fecha = fecha;
       this.envios = envios;
    }
   
    public int getNumFactura() {
        return this.numFactura;
    }
    
    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Double getTotal() {
        return this.total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Set<Envio> getEnvios() {
        return this.envios;
    }
    
    public void setEnvios(Set<Envio> envios) {
        this.envios = envios;
    }




}


