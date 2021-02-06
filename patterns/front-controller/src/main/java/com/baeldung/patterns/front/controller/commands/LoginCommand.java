package com.baeldung.patterns.front.controller.commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        if (request.getMethod().equals("POST")) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", request.getParameter("username"));
            response.sendRedirect(request.getParameter("redirect"));
        } else {
            String url = request.getRequestURL()+"?"+request.getQueryString();
            request.setAttribute("redirect", url);
            forward("login");
        }
    }
}