/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.*;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Item;
import model.Producto;
import persistencia.NewHibernateUtil;

/**
 *
 * @author Juan José Ponce
 */
@ManagedBean
@ViewScoped
public class cartBean implements Serializable {

    private List<Item> cart = new ArrayList<Item>();

    private float total;
    private Item selectedItem = new Item();

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public cartBean() {
    }

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    public float getTotal() {
        total = 0;
        for (Item item : cart) {
            total += item.getValorTotal();
        }
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    /* Funcion agrega un producto a la lista del carrito de compras
       Si el producto ya esta en la lista, agrega una unidad a la cantidad de este*/
    public List<Item> addtoCart(Producto p, Integer cantidad) {
        for (Item item : cart) {
            if (item.getProducto().getIdProducto() == p.getIdProducto()) {
                if (cantidad + item.getCantidad() <= p.getStock()) {
                    item.setCantidad(cantidad + item.getCantidad());
                    item.setValorTotal(item.getCantidad() * (p.getPrecio() - (p.getPrecio() / 100) * p.getDescuento()));
                    item.setId(p.getIdProducto());

                    addMessage("Agregado al carrito!!");
                } else {
                    addMessage("No hay stock!!");
                }
                return cart;
            }

        }
        if (cantidad <= p.getStock()) {
            Item item1 = new Item();
            item1.setCantidad(cantidad);
            item1.setProducto(p);
            item1.setValorTotal(cantidad * (p.getPrecio() - (p.getPrecio() / 100) * p.getDescuento()));
            item1.setId(p.getIdProducto());
            cart.add(item1);

            addMessage("Agregado al carrito!!");
        } else {
            addMessage("No hay stock!!");
        }
        return cart;
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void remove() {
        cart.remove(selectedItem);
    }

    public String payment() {
        return "pago";
    }

}
