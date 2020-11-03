/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Categoria;
import model.Producto;

/**
 *
 * @author Lenovo
 */
public interface productoDao {
    public void insertar(Producto producto);
    public void actualizar(Producto producto);
    public void eliminar(Producto producto);
    public List<Producto> categoriaProductos(Categoria categoria);
    public List<Producto> mostrar();
    public List<Producto> mstock(String id);
    public List<Producto> buscar(String nombre, String categoria);
    
}
