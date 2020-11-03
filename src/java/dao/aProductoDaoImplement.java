/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.List;
import model.AuditoriaProducto;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.NewHibernateUtil;

/**
 *
 * @author Lenovo
 */
public class aProductoDaoImplement implements aProductoDao {
    @Override
    public void insertar(AuditoriaProducto auditoriaProducto) {
        Session session= null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(auditoriaProducto);
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
    public void actualizar(AuditoriaProducto auditoriaProducto) {
        Session session= null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(auditoriaProducto);
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
    public void eliminar(AuditoriaProducto auditoriaProducto) {
        Session session= null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(auditoriaProducto);
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
    public List<AuditoriaProducto> mostrar() {
        Session session = null;
        List<AuditoriaProducto> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from model.AuditoriaProducto");
            lista = (List<AuditoriaProducto>) query.list();
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
