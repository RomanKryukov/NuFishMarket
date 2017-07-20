package com.managers;



import com.Factory.Factory;
import com.entity.User;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by Roman on 18.07.2017.
 */
public class LoginManagers {
    public String[] loginController(Map<String, String[]> paramMap) throws Exception {
        String[] resultData = new String [2];
        String name = paramMap.get("login")[0];
        String password = paramMap.get("password")[0];
        User currentUser = null;
        try {
            currentUser = Factory.getInstance().getUserDAO().getUserByNikName(name);
        }catch(SQLException e){
            System.err.println("Enable to connect");
            e.printStackTrace();
        }
        if(currentUser!=null){
            String tempPassword = currentUser.getPassword();
            if(password.equals(tempPassword)) {
                resultData[0] = currentUser.getNikName();
                resultData[1] = String.valueOf(currentUser.getIdUser());
                return resultData;
            } throw new Exception();
        }else{
            throw new Exception();
        }

    }
}
