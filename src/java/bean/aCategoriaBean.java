/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.aCategoriaDao;
import dao.aCategoriaDaoImplement;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.AuditoriaCategoria;

@ManagedBean
@ViewScoped
/**
 *
 * @author Lenovo
 */
public class aCategoriaBean implements Serializable {
    private AuditoriaCategoria auditoriaCategoria;
    private List<AuditoriaCategoria> lista;
     
    public aCategoriaBean() {
        auditoriaCategoria = new AuditoriaCategoria();
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
     public void insertar(){
        aCategoriaDao dao = new  aCategoriaDaoImplement();
        dao.insertar(auditoriaCategoria);
        auditoriaCategoria= new AuditoriaCategoria();
        addMessage("AuditoriaCategoria agregado!");
    }
     
      public void eliminar(){
        aCategoriaDao dao = new  aCategoriaDaoImplement();
        dao.eliminar(auditoriaCategoria);
        auditoriaCategoria = new AuditoriaCategoria();
        addMessage("AuditoriaCategoria Eliminado!");
    }
     
     public void actualizar(){
        aCategoriaDao dao = new  aCategoriaDaoImplement();
        dao.actualizar(auditoriaCategoria);
        auditoriaCategoria = new AuditoriaCategoria();
        addMessage("AuditoriaCategoria Actualizado!");
    }
    
    /**
     * @return the auditoriaCategoria
     */
    public AuditoriaCategoria getCategoria() {
        return auditoriaCategoria;
    }

    /**
     * @param auditoriaCategoria the auditoriaCategoria to set
     */
    public void setCategoria(AuditoriaCategoria auditoriaCategoria) {
        this.auditoriaCategoria = auditoriaCategoria;
    }

    /**
     * @return the lista
     */
    public List<AuditoriaCategoria> getLista() {
        aCategoriaDao dao = new  aCategoriaDaoImplement();
        this.lista = dao.mostrar();
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<AuditoriaCategoria> lista) {
        this.lista = lista;
    }
    
    public AuditoriaCategoria create() {
        this.auditoriaCategoria = new AuditoriaCategoria();
        return auditoriaCategoria;
    }
    
}