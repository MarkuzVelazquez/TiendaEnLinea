/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.*;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import model.Producto;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.NewHibernateUtil;

/**
 *
 * @author Lenovo
 */
public class productoDaoImplement implements productoDao {

    @Override
    public void insertar(Producto producto) {
        Session session= null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(producto);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public void actualizar(Producto producto) {
        Session session= null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(producto);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public void eliminar(Producto producto) {
        Session session= null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(producto);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public List<Producto> mostrar() {
        Session session = null;
        List<Producto> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from model.Producto");
            lista = (List<Producto>) query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }finally{
            if (session != null) {
                session.close();
            }
        }
        return lista;
    }
    
    @Override
    public List<Producto> mstock(String id) {
        Session session = null;
        List<Producto> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from model.Producto where id_producto= " + id);
            lista = (List<Producto>) query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }finally{
            if (session != null) {
                session.close();
            }
        }
        return lista;
    }
    
    @Override
    public List<Producto> buscar(String bnombre, String categoria) {
        Session session = null;
        List<Producto> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query;
            System.out.println(categoria);
            if (categoria != null) {
                query = session.createQuery("from model.Producto where categoria = "+categoria+" and (nombre like '%"+bnombre+"%' or descripcion like '%"+bnombre+"%')");
            }
            else {
                query = session.createQuery("from model.Producto where nombre like '%"+bnombre+"%' or descripcion like '%"+bnombre+"%'");
            }
            lista = (List<Producto>) query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }finally{
            if (session != null) {
                session.close();
            }
        }
        return lista;
    }
    
    @Override
    public List<Producto> categoriaProductos(Categoria categoria) {
        Session session = null;
        List<Producto> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from model.Producto where id_categoria="+categoria.getIdCategoria());
            lista = (List<Producto>) query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }finally{
            if (session != null) {
                session.close();
            }
        }
        return lista;
    }
    
}
