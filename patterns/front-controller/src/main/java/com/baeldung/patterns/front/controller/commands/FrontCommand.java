package com.baeldung.patterns.front.controller.commands;

import com.baeldung.patterns.front.controller.filters.FilterManager;
import com.baeldung.patterns.front.controller.filters.OnIntercept;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class FrontCommand implements OnIntercept {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    private boolean intercepted;

    public void init(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        this.request = servletRequest;
        this.response = servletResponse;
    }

    public void process() throws ServletException, IOException {
        FilterManager.filter(request, response, this);
    }

    protected void forward(String target) throws ServletException, IOException {
        if (intercepted) {
            return;
        }
        String path = String.format("/WEB-INF/jsp/%s.jsp", target);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

    @Override
    public void intercept() {
        intercepted = true;
    }
}
