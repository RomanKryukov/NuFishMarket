package com.webapp;

import com.managers.LoginManagers;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Roman on 18.07.2017.
 */
public class LoginServlet extends APIHandlerServlet.APIRequestHandler {

    public static final LoginServlet instance = new LoginServlet();


    public static LoginServlet getInstance() {
        return instance;
    }

    private LoginServlet() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        LoginManagers loginManager = new LoginManagers();
        String[] param = new String [2];
        JSONObject jsonObject = new JSONObject();
        try {
            param = loginManager.loginController(map);
        }catch(Exception e){
            jsonObject.put("name","error");
            jsonObject.put("indexNumber","not_exist");
            return jsonObject;
        }

        jsonObject.put("name", param[0]);
        jsonObject.put("indexNumber", param[1]);
        return jsonObject;
    }
}
