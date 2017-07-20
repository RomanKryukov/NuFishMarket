package com.dao;

import com.Factory.HibernateSessionFactory;

import com.entity.FishingRods;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Roman on 05.07.2017.
 */
public class FishingRodsDAOImpl implements FishingRodsDAO {
    @Override
    public void addFishingRods(FishingRods fishingRods) throws SQLException {
        Session session = null;
        try{
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(fishingRods);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);

        }finally {
            if (session != null & session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void updateFishingRods(FishingRods fishingRods) throws SQLException {
        Session session = null;
        try{ session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(fishingRods);
            session.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);

        }finally {
            if (session != null & session.isOpen()){
                session.close();
            }
        }
    }



    @Override
    public void deleteFishingRods(FishingRods fishingRods) throws SQLException {
        Session session = null;
        try{ session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(fishingRods);
            session.getTransaction().commit();
        }catch (Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
                e.printStackTrace();
        }finally {
            if (session != null & session.isOpen()){
                session.close();
            }
        }
    }



    @Override
    public List getAllFishingRods() throws SQLException {

        List<FishingRods> fishingRodsList = new ArrayList<FishingRods>();
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            fishingRodsList = session.createCriteria(FishingRods.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session != null & session.isOpen()){
                session.close();
            }
        }

        return fishingRodsList;
    }

    @Override
    public FishingRods getCategory(String category) throws SQLException {
        Session session = null;
        FishingRods fishingRods = null;
        try{
            session = HibernateSessionFactory.getSessionFactory().openSession();
            fishingRods =  session.load(FishingRods.class, category);


        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);

        }finally {
            if (session != null & session.isOpen()){
                session.close();
            }
        }
        return fishingRods;
    }


}
