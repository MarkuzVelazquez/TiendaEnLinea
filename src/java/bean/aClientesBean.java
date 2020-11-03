/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.aClienteDao;
import dao.aClienteDaoImplement;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.AuditoriaClientes;

@ManagedBean
@ViewScoped
/**
 *
 * @author Lenovo
 */
public class aClientesBean implements Serializable {
    private AuditoriaClientes auditoriaClientes;
    private List<AuditoriaClientes> lista;
     
    public aClientesBean() {
        auditoriaClientes = new AuditoriaClientes();
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
     public void insertar(){
        aClienteDao dao = new  aClienteDaoImplement();
        dao.insertar(auditoriaClientes);
        auditoriaClientes= new AuditoriaClientes();
        addMessage("AuditoriaClientes agregado!");
    }
     
      public void eliminar(){
        aClienteDao dao = new  aClienteDaoImplement();
        dao.eliminar(auditoriaClientes);
        auditoriaClientes = new AuditoriaClientes();
        addMessage("AuditoriaClientes Eliminado!");
    }
     
     public void actualizar(){
        aClienteDao dao = new  aClienteDaoImplement();
        dao.actualizar(auditoriaClientes);
        auditoriaClientes = new AuditoriaClientes();
        addMessage("AuditoriaClientes Actualizado!");
    }
    
    /**
     * @return the auditoriaClientes
     */
    public AuditoriaClientes getCategoria() {
        return auditoriaClientes;
    }

    /**
     * @param auditoriaClientes the auditoriaClientes to set
     */
    public void setCategoria(AuditoriaClientes auditoriaClientes) {
        this.auditoriaClientes = auditoriaClientes;
    }

    /**
     * @return the lista
     */
    public List<AuditoriaClientes> getLista() {
        aClienteDao dao = new  aClienteDaoImplement();
        this.lista = dao.mostrar();
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<AuditoriaClientes> lista) {
        this.lista = lista;
    }
    
    public AuditoriaClientes create() {
        this.auditoriaClientes = new AuditoriaClientes();
        return auditoriaClientes;
    }
    
}