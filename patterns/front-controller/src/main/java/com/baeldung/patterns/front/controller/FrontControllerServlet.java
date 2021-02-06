package com.baeldung.patterns.front.controller;

import com.baeldung.patterns.front.controller.commands.FrontCommand;
import com.baeldung.patterns.front.controller.commands.UnknownCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "front-controller", urlPatterns = "/")
public class FrontControllerServlet extends HttpServlet {
    @Override
    protected void doGet(
      HttpServletRequest request,
      HttpServletResponse response
    ) throws ServletException, IOException {
        doCommand(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doCommand(request, response);
    }

    private void doCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FrontCommand command = getCommand(request);
        command.init(request, response);
        command.process();
    }

    private FrontCommand getCommand(HttpServletRequest request) {
        try {
            Class type = Class.forName(
              String.format(
                "com.baeldung.patterns.front.controller.commands.%sCommand",
                request.getParameter("command")
              )
            );
            return (FrontCommand) type
              .asSubclass(FrontCommand.class)
              .getDeclaredConstructor()
              .newInstance();
        } catch (Exception e) {
            return new UnknownCommand();
        }
    }
}
