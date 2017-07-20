package com.dao;


import com.entity.User;


import java.sql.SQLException;
import java.util.List;

/**
 * Created by Roman on 13.07.2017.
 */
public interface UserDAO {
    void addUser(User user) throws SQLException;
    void updateUser(User user) throws SQLException;
    void deleteUser(User user) throws SQLException;
    User getUserByNikName(String nikName) throws SQLException;
    User getUserById(long id) throws SQLException;
    List<User> getAllUsersData() throws SQLException;

}
