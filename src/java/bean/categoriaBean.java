/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.categoriaDao;
import dao.categoriaDaoImplement;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Categoria;

@ManagedBean
@ViewScoped
/**
 *
 * @author Lenovo
 */
public class categoriaBean implements Serializable {
    private Categoria categoria;
    private List<Categoria> lista;
     
    public categoriaBean() {
        categoria = new Categoria();
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
     public void insertar(){
        categoriaDao dao = new  categoriaDaoImplement();
        dao.insertar(categoria);
        categoria= new Categoria();
        addMessage("Categoria agregado!");
    }
     
      public void eliminar(){
        categoriaDao dao = new  categoriaDaoImplement();
        dao.eliminar(categoria);
        categoria = new Categoria();
        addMessage("Categoria Eliminado!");
    }
     
     public void actualizar(){
        categoriaDao dao = new  categoriaDaoImplement();
        dao.actualizar(categoria);
        categoria = new Categoria();
        addMessage("Categoria Actualizado!");
    }
    
    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the lista
     */
    public List<Categoria> getLista() {
        categoriaDao dao = new  categoriaDaoImplement();
        this.lista = dao.mostrar();
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Categoria> lista) {
        this.lista = lista;
    }
    
    public Categoria create() {
        this.categoria = new Categoria();
        return categoria;
    }
    
}