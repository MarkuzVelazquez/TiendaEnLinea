/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Factura;

/**
 *
 * @author Lenovo
 */
public interface facturaDao {
    public void insertar(Factura factura);
    public void actualizar(Factura factura);
    public void eliminar(Factura factura);
    public List<Factura> mostrar();
}
