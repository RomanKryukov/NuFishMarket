package com.dao;

import com.entity.FishingRods;

import java.sql.SQLException;

/**
 * Created by Roman on 05.07.2017.
 */
public interface FishingRodsDAO {
     void addFishingRods(FishingRods fishingRods) throws SQLException;
     void updateFishingRods(FishingRods fishingRods) throws SQLException;
     void deleteFishingRods(FishingRods fishingRods) throws SQLException;
     java.util.List<FishingRods> getAllFishingRods() throws SQLException;
     FishingRods getCategory(String category) throws SQLException;

}
