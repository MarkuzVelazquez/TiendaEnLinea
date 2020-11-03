/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.aFacturaDao;
import dao.aFacturaDaoImplement;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.AuditoriaFactura;

@ManagedBean
@ViewScoped
/**
 *
 * @author Lenovo
 */
public class aFacturaBean implements Serializable {
    private AuditoriaFactura auditoriaFactura;
    private List<AuditoriaFactura> lista;
     
    public aFacturaBean() {
        auditoriaFactura = new AuditoriaFactura();
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
     public void insertar(){
        aFacturaDao dao = new  aFacturaDaoImplement();
        dao.insertar(auditoriaFactura);
        auditoriaFactura= new AuditoriaFactura();
        addMessage("AuditoriaFactura agregado!");
    }
     
      public void eliminar(){
        aFacturaDao dao = new  aFacturaDaoImplement();
        dao.eliminar(auditoriaFactura);
        auditoriaFactura = new AuditoriaFactura();
        addMessage("AuditoriaFactura Eliminado!");
    }
     
     public void actualizar(){
        aFacturaDao dao = new  aFacturaDaoImplement();
        dao.actualizar(auditoriaFactura);
        auditoriaFactura = new AuditoriaFactura();
        addMessage("AuditoriaFactura Actualizado!");
    }
    
    /**
     * @return the auditoriaFactura
     */
    public AuditoriaFactura getCategoria() {
        return auditoriaFactura;
    }

    /**
     * @param auditoriaFactura the auditoriaFactura to set
     */
    public void setCategoria(AuditoriaFactura auditoriaFactura) {
        this.auditoriaFactura = auditoriaFactura;
    }

    /**
     * @return the lista
     */
    public List<AuditoriaFactura> getLista() {
        aFacturaDao dao = new  aFacturaDaoImplement();
        this.lista = dao.mostrar();
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<AuditoriaFactura> lista) {
        this.lista = lista;
    }
    
    public AuditoriaFactura create() {
        this.auditoriaFactura = new AuditoriaFactura();
        return auditoriaFactura;
    }
    
}