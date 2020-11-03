/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.AuditoriaProducto;

/**
 *
 * @author Lenovo
 */
public interface aProductoDao {
    public void insertar(AuditoriaProducto auditoriaProducto);
    public void actualizar(AuditoriaProducto auditoriaProducto);
    public void eliminar(AuditoriaProducto auditoriaProducto);
    public List<AuditoriaProducto> mostrar();
}
