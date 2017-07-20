package com.webapp;

import com.Factory.Factory;
import com.entity.User;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Roman on 18.07.2017.
 */
public class RegistrationServlet extends APIHandlerServlet.APIRequestHandler{
    public static final RegistrationServlet instance = new RegistrationServlet();


    public static RegistrationServlet getInstance() {
        return instance;
    }

    private RegistrationServlet() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User();
        user.setEmail(email);
        user.setNikName(login);
        user.setPassword(password);
        Factory.getInstance().getUserDAO().addUser(user);

        System.out.println("login: " + login + "; email: " + email + "; password: " + password);
        return null;
    }
}
