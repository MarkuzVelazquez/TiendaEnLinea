/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Detalle;

/**
 *
 * @author Lenovo
 */
public interface detalleDao {
    public void insertar(Detalle detalle);
    public void actualizar(Detalle detalle);
    public void eliminar(Detalle detalle);
    public List<Detalle> mostrar();
}
