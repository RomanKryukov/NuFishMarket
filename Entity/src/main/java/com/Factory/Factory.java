package com.Factory;

import com.dao.FishingRodsDAO;
import com.dao.FishingRodsDAOImpl;
import com.dao.UserDAO;
import com.dao.UserDAOImpl;

/**
 * Created by Roman on 05.07.2017.
 */
public class Factory {
    private static FishingRodsDAO fishingRodsDAO = null;
    private static UserDAO userDAO = null;
    private static Factory instance = null;
    public static strictfp Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public FishingRodsDAO getFishingRodsDAO(){
        if(fishingRodsDAO == null){
            fishingRodsDAO = new FishingRodsDAOImpl();
        }
        return fishingRodsDAO;
    }

    public UserDAO getUserDAO() {
        if(userDAO == null){
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }
}
