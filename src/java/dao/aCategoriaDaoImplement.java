/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.List;
import model.AuditoriaCategoria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.NewHibernateUtil;

/**
 *
 * @author Lenovo
 */
public class aCategoriaDaoImplement implements aCategoriaDao {
    @Override
    public void insertar(AuditoriaCategoria auditoriaCategoria) {
        Session session= null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(auditoriaCategoria);
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
    public void actualizar(AuditoriaCategoria auditoriaCategoria) {
        Session session= null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(auditoriaCategoria);
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
    public void eliminar(AuditoriaCategoria auditoriaCategoria) {
        Session session= null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(auditoriaCategoria);
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
    public List<AuditoriaCategoria> mostrar() {
        Session session = null;
        List<AuditoriaCategoria> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from model.AuditoriaCategoria");
            lista = (List<AuditoriaCategoria>) query.list();
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
