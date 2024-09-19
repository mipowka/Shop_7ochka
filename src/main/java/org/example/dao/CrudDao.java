package org.example.dao;

import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

public  class  CrudDao <T,ID extends Serializable>{

    private Class<T> entityType;

    //create
    public void add(T t){
        Transaction transaction = null;

        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(t);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
                System.out.println("rollback");
            }
        }
    }

    //read
    public T getById(ID id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.find(entityType, id);
    }

    //update
    public void update(T t){
        Transaction transaction = null;

        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.merge(t);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    //delete
    public void delete(ID id){
        Transaction transaction = null;

        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            T t = session.get(entityType, id);
            session.remove(t);
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

}
