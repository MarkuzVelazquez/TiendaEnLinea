/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.clienteDao;
import dao.clienteDaoImplement;
import dao.detalleDao;
import dao.detalleDaoImplement;
import dao.facturaDao;
import dao.facturaDaoImplement;
import dao.productoDao;
import dao.productoDaoImplement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Cliente;
import model.Detalle;
import model.Factura;
import model.Item;
import model.Producto;
import persistencia.NewHibernateUtil;

/**
 *
 * @author Juan José Ponce
 */
@ManagedBean
@ViewScoped
public class facturaBean implements Serializable {

    private Factura factura;

    clienteDao clienteDao = new clienteDaoImplement();
    private List<Item> cart = new ArrayList<Item>();
    List<Item> carroPayPal = new ArrayList<Item>();
    Cliente cliente1 = new Cliente();
    private float subtotal;
    private float valorIva;
    private float total;
    private String busqueda;
    private List<Factura> ventas;
    private List<Factura> selectedVentas;

    private List<Factura> lista;

    public facturaBean() {
        factura = new Factura();
    }

    public facturaBean(Cliente user) {
        cliente1 = user;
    }

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    public Cliente getCliente1() {
        return cliente1;
    }

    public void setCliente1(Cliente cliente1) {
        this.cliente1 = cliente1;
    }

    public float getSubtotal() {
        subtotal = 0;
        for (Item item : cart) {
            subtotal += item.getValorTotal();
        }

        return subtotal;
    }

    public void setSubtotal(float subtotal) {

        this.subtotal = subtotal;
    }

    public float getValorIva() {
        valorIva = 0;
        for (Item item : cart) {
            valorIva += item.getValorTotal() * 0.14;
        }
        return valorIva;
    }

    public void setValorIva(float valorIva) {
        this.valorIva = valorIva;
    }

    public float getTotal() {
        total = 0;
        for (Item item : cart) {
            total += item.getValorTotal() * 1.14;
        }
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public List<Factura> getVentas() {
        facturaDao ventaDao = new facturaDaoImplement();
        ventas = ventaDao.mostrar();
        return ventas;
    }

    public void setVentas(List<Factura> ventas) {
        this.ventas = ventas;
    }
    
    public List<Factura> getSelectedVentas() {
        return selectedVentas;
    }

    public void setSelectedVentas(List<Factura> selectedVentas) {
        this.selectedVentas = selectedVentas;
    }

    public List<Item> getCarroPayPal() {
        return carroPayPal;
    }

    public void setCarroPayPal(List<Item> carroPayPal) {
        this.carroPayPal = carroPayPal;
    }

    /* Funcion para insertar una factura
       Recorre toda la lista del carrito de compras y agrega 
       cada producto de la lista a la tabla detalle factura.
       Tambien calcula el total.
    */
    public void insertar(double totalVenta, Cliente cliente, cartBean carroC) {
        Factura venta = new Factura();
        // inserta factura
        facturaDao dao = new facturaDaoImplement();
        productoDao prodDao = new productoDaoImplement();
        venta.setCliente(cliente);
        venta.setTotal(totalVenta);
        venta.setFecha(null);
        dao.insertar(venta);
        Detalle detalle = new Detalle();
        detalleDao detDao = new detalleDaoImplement();
        Producto prod;
        // agregar los productos a detalle factura
        for (Item item : carroC.getCart()) {
            prod = item.getProducto();
            Integer total = prod.getStock() - item.getCantidad();
            prod.setStock(total);
            prodDao.actualizar(prod);
            detalle.setFactura(venta);
            detalle.setNombreProd(prod.getNombre());
            detalle.setCantidad(item.getCantidad());
            detalle.setPrecio(item.getValorTotal());
            detDao.insertar(detalle);
        }
        // Limpiar la lista del carrito
        List<Item> cart1 = new ArrayList<Item>();
        carroC.setCart(cart1);
        addMessage("Venta Completada");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the lista
     */
    public List<Factura> getLista() {
        facturaDao dao = new facturaDaoImplement();
        this.lista = dao.mostrar();
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Factura> lista) {
        this.lista = lista;
    }
}
