package com.baeldung.patterns.front.controller.commands;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class FrontCommand {
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public void init(
      HttpServletRequest servletRequest,
      HttpServletResponse servletResponse
    ) {
        this.request = servletRequest;
        this.response = servletResponse;
    }

    public abstract void process() throws ServletException, IOException;

    protected void forward(String target) throws ServletException, IOException {
        String path = String.format("/WEB-INF/jsp/%s.jsp", target);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
}
