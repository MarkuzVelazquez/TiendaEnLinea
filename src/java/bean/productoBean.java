/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.categoriaDao;
import dao.categoriaDaoImplement;
import dao.productoDao;
import dao.productoDaoImplement;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.Categoria;
import model.Producto;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@ViewScoped
/**
 *
 * @author Lenovo
 */
public class productoBean implements Serializable {

    private Producto selectProducto;
    private String input1;
    private String selectCategoria;
    private String inombre = "";
    private Integer cantidad;
    private Integer stock;
    private String stockProd;
    
    private List<SelectItem> listProducto;
            
    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    private Producto producto;
    private List<Producto> lista;
    private List<SelectItem> listCategoria;
    private List<Producto> buscar;

    
    public productoBean() {
        producto = new Producto();
    }

    public List<Producto> getBuscar() {
        productoDao dao = new productoDaoImplement();
        this.buscar = dao.buscar(inombre, selectCategoria);
        return buscar;
    }

    public void setBuscar(List<Producto> buscar) {
        this.buscar = buscar;
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void insertar() {
        productoDao dao = new productoDaoImplement();
        dao.insertar(producto);
        producto = new Producto();
        addMessage("Producto agregado!!");
    }

    public void eliminar() {
        productoDao dao = new productoDaoImplement();
        dao.eliminar(producto);
        producto = new Producto();
        addMessage("Producto Eliminado!!");
    }

    public void actualizar() {
        productoDao dao = new productoDaoImplement();
        dao.actualizar(producto);
        producto = new Producto();
        addMessage("Producto Actualizado!!");

    }
    
    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the lista
     */
    public List<Producto> getLista() {
        productoDao dao = new productoDaoImplement();
        this.lista = dao.mostrar();
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }

    /**
     * @return the listCategoriaID
     */
    public List<SelectItem> getListCategoria() {
        this.setListCategoria(new ArrayList<SelectItem>());
        categoriaDao dao = new categoriaDaoImplement();
        List<Categoria> p = dao.mostrar();
        listCategoria.clear();
        try {
            for (Categoria categoria : p) {
                SelectItem categoriaItem = new SelectItem(categoria.getIdCategoria(), categoria.getNombre());
                this.listCategoria.add(categoriaItem);
            }
        }catch (NullPointerException npe){
             npe.printStackTrace();
        }
        return listCategoria;
    }

    /**
     * @param listCategoria the listCategoria to set
     */
    public void setListCategoria(List<SelectItem> listCategoria) {
        this.listCategoria = listCategoria;
    }

    public void upload() {
        if (file != null) {
            String asd = file.getFileName();
            FacesMessage message = new FacesMessage("Succesful", file + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            producto.setImage(asd);

        }
    }

    private String destination = "/img/";

    public void handleFileUpload(FileUploadEvent event) {
        String asd = event.getFile().getFileName();

        File af = new File(destination + asd);

        if (!af.exists()) {
            FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            producto.setImage(asd);
            // Do what you want with the file
            try {
                copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", event.getFile().getFileName() + " ya existe.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void copyFile(String fileName, InputStream in) {
        try {

            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(destination + fileName));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    /**
     * @return the selectProducto
     */
    public Producto getSelectProducto() {
        return selectProducto;
    }

    /**
     * @param selectProducto the selectProducto to set
     */
    public void setSelectProducto(Producto selectProducto) {
        this.selectProducto = selectProducto;
    }

    public String getInput1() {
        return input1;
    }

    public void setInput1(String input1) {
        this.input1 = input1;
    }

    public String getInombre() {
        return inombre;
    }

    public void setInombre(String inombre) {
        this.inombre = inombre;
    }

    public String getSelectCategoria() {
        return selectCategoria;
    }

    public void setSelectCategoria(String selectCategoria) {
        this.selectCategoria = selectCategoria;
    }

    /**
     * @return the stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * @return the stockProd
     */
    public String getStockProd() {
        return stockProd;
    }

    /**
     * @param stockProd the stockProd to set
     */
    public void setStockProd(String stockProd) {
        this.stockProd = stockProd;
    }

    
    
    public void addStock(String idssp, int ssap) {
        productoDao prodDao = new productoDaoImplement();
        Producto ssp = prodDao.mstock(idssp).get(0);
        Integer total = ssp.getStock() + ssap;
        if (total >= 0) {
            ssp.setStock(total);
            prodDao.actualizar(ssp);
            addMessage("Stock agregado!");
        }
         else {
            addMessage("No tiene suficiente stock, stock:" + ssp.getStock());
        }
    }
    
    public void subStock(String idssp, int ssap) {
        productoDao prodDao = new productoDaoImplement();
        Producto ssp = prodDao.mstock(idssp).get(0);
        Integer total = ssp.getStock() - ssap;
        if (total >= 0) {
            ssp.setStock(total);
            prodDao.actualizar(ssp);
            addMessage("Stock quitado!");
        }
        else {
            addMessage("No tiene suficiente stock, stock:" + ssp.getStock());
        }
    }

        public List<SelectItem> getListProducto() {
        this.setListProducto(new ArrayList<SelectItem>());
        productoDao dao = new productoDaoImplement();
        List<Producto> p = dao.mostrar();
        listProducto.clear();
        try {
            for (Producto producto : p) {
                SelectItem productoItem = new SelectItem(producto.getIdProducto(), producto.getNombre());
                this.listProducto.add(productoItem);
            }
        }catch (NullPointerException npe){
             npe.printStackTrace();
        }
        return listProducto;
    }
        
        public void setListProducto(List<SelectItem> listProducto) {
        this.listProducto = listProducto;
    }

}
