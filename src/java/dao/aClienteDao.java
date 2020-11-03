/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.AuditoriaClientes;

/**
 *
 * @author Lenovo
 */
public interface aClienteDao {
    public void insertar(AuditoriaClientes auditoriaClientes);
    public void actualizar(AuditoriaClientes auditoriaClientes);
    public void eliminar(AuditoriaClientes auditoriaClientes);
    public List<AuditoriaClientes> mostrar();
}
