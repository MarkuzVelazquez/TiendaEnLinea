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
public interface categoriaDao {
    public void insertar(Categoria categoria);
    public void actualizar(Categoria categoria);
    public void eliminar(Categoria categoria);
    public String select(Categoria categoria);
    public List<Categoria> mostrar();
}
