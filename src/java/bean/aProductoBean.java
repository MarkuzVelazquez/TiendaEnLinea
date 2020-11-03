/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.aProductoDao;
import dao.aProductoDaoImplement;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.AuditoriaProducto;

@ManagedBean
@ViewScoped
/**
 *
 * @author Lenovo
 */
public class aProductoBean implements Serializable {
    private AuditoriaProducto auditoriaProducto;
    private List<AuditoriaProducto> lista;
     
    public aProductoBean() {
        auditoriaProducto = new AuditoriaProducto();
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
     public void insertar(){
        aProductoDao dao = new  aProductoDaoImplement();
        dao.insertar(auditoriaProducto);
        auditoriaProducto= new AuditoriaProducto();
        addMessage("AuditoriaProducto agregado!");
    }
     
      public void eliminar(){
        aProductoDao dao = new  aProductoDaoImplement();
        dao.eliminar(auditoriaProducto);
        auditoriaProducto = new AuditoriaProducto();
        addMessage("AuditoriaProducto Eliminado!");
    }
     
     public void actualizar(){
        aProductoDao dao = new  aProductoDaoImplement();
        dao.actualizar(auditoriaProducto);
        auditoriaProducto = new AuditoriaProducto();
        addMessage("AuditoriaProducto Actualizado!");
    }
    
    /**
     * @return the auditoriaProducto
     */
    public AuditoriaProducto getCategoria() {
        return auditoriaProducto;
    }

    /**
     * @param auditoriaProducto the auditoriaProducto to set
     */
    public void setCategoria(AuditoriaProducto auditoriaProducto) {
        this.auditoriaProducto = auditoriaProducto;
    }

    /**
     * @return the lista
     */
    public List<AuditoriaProducto> getLista() {
        aProductoDao dao = new  aProductoDaoImplement();
        this.lista = dao.mostrar();
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<AuditoriaProducto> lista) {
        this.lista = lista;
    }
    
    public AuditoriaProducto create() {
        this.auditoriaProducto = new AuditoriaProducto();
        return auditoriaProducto;
    }
    
}