/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.AuditoriaCategoria;

/**
 *
 * @author Lenovo
 */
public interface aCategoriaDao {
    public void insertar(AuditoriaCategoria auditoriaCategoria);
    public void actualizar(AuditoriaCategoria auditoriaCategoria);
    public void eliminar(AuditoriaCategoria auditoriaCategoria);
    public List<AuditoriaCategoria> mostrar();
}
