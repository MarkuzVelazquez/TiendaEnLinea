/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.AuditoriaFactura;

/**
 *
 * @author Lenovo
 */
public interface aFacturaDao {
    public void insertar(AuditoriaFactura auditoriaFactura);
    public void actualizar(AuditoriaFactura auditoriaFactura);
    public void eliminar(AuditoriaFactura auditoriaFactura);
    public List<AuditoriaFactura> mostrar();
}
