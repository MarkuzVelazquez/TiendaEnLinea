/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Cliente;

/**
 *
 * @author Markuz Velazquez
 */
public interface clienteDao {
    public void insertar(Cliente cliente);
    public void actualizar(Cliente cliente);
    public void eliminar(Cliente cliente);
    public List<Cliente> mostrar();
}

