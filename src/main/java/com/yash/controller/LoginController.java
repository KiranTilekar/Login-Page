package com.yash.controller;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import com.yash.model.Login;
import com.yash.service.*;

public class LoginController extends HttpServlet {
	
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {

        String action = request.getParameter("action");
        
        Login user = new Login(request.getParameter("username"), request.getParameter("password"));
        LoginService loginService = new LoginServiceImpl();

        switch (action) {
            case "login":
                if (loginService.authenticateUser(user)) {
//                	request.setAttribute("username", user.getUsername());
                	HttpSession session = request.getSession();
                    session.setAttribute("username", user.getUsername());
                    
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome.jsp");
                    dispatcher.forward(request, response);
                } else {
                	response.sendRedirect("register.jsp");
                }
                break;
            case "register":
                loginService.registerUser(user);
                response.sendRedirect("login.jsp");
                break;
        }
    }
}
