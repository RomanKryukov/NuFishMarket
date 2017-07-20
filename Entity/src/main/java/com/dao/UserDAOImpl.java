package com.dao;

import com.Factory.HibernateSessionFactory;
import com.entity.User;
import org.hibernate.Session;



import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Roman on 13.07.2017.
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public void addUser(User user) throws SQLException {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);

        } finally {
            if (session != null & session.isOpen()) {
                session.close();
            }
        }

    }

    @Override
    public void updateUser(User user) throws SQLException {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);

        } finally {
            if (session != null & session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void deleteUser(User user) throws SQLException {
            Session session =null;
        try { session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);

        } finally {
            if (session != null & session.isOpen()) {
                session.close();
            }
        }

    }

    @Override
    public User getUserByNikName(String nikName) throws SQLException {
        User user = null;
        try {Session session = HibernateSessionFactory.getSessionFactory().openSession();
            org.hibernate.query.Query query = session.createQuery("FROM User WHERE name =:nikName");
            query.setParameter("nikName", nikName);
            user = (User) query.uniqueResult();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
        }
        return user;

    }

    @Override
    public User getUserById(long id) throws SQLException {
        User user = null;
        try {Session session = HibernateSessionFactory.getSessionFactory().openSession();
            org.hibernate.query.Query query = session.createQuery("FROM User WHERE name =:idUser");
            query.setParameter("idUser", id);
            user = (User) query.uniqueResult();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
        }
        return user;
    }

    @Override
    public List<User> getAllUsersData() throws SQLException {
        List<User> users = new ArrayList<User>();
        Session session = null;
        try {session = HibernateSessionFactory.getSessionFactory().openSession();
            users = session.createCriteria(User.class).list();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session != null & session.isOpen()){
                session.close();
            }
        }


        return users;
    }


}