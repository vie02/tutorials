package com.baeldung.patterns.front.controller.commands;

import javax.servlet.ServletException;
import java.io.IOException;

public class LoginCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        forward("login");
    }
}
