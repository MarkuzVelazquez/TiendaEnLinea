/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.detalleDao;
import dao.detalleDaoImplement;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Detalle;


@ManagedBean
@ViewScoped
/**
 *
 * @author Lenovo
 */
public class detalleBean implements Serializable {
    private Detalle detalle;
    private List<Detalle> lista;
     
    public detalleBean() {
        detalle = new Detalle();
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
     public void insertar(){
        detalleDao dao = new  detalleDaoImplement();
        dao.insertar(detalle);
        detalle= new Detalle();
        addMessage("Detalle agregado!!");
    }
     
      public void eliminar(){
        detalleDao dao = new  detalleDaoImplement();
        dao.eliminar(detalle);
        detalle = new Detalle();
        addMessage("Detalle Eliminado!!");
    }
     
     public void actualizar(){
        detalleDao dao = new  detalleDaoImplement();
        dao.actualizar(detalle);
        detalle = new Detalle();
        addMessage("Detalle Actualizado!!");
    }
    
    /**
     * @return the detalle
     */
    public Detalle getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the categoria to set
     */
    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    /**
     * @return the lista
     */
    public List<Detalle> getLista() {
        detalleDao dao = new  detalleDaoImplement();
        this.lista = dao.mostrar();
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Detalle> lista) {
        this.lista = lista;
    }
    
    public Detalle create() {
        this.detalle = new Detalle();
        return detalle;
    }
    
}