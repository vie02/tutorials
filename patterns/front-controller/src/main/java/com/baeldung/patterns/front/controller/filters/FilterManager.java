package com.baeldung.patterns.front.controller.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterManager {
    public static void filter(HttpServletRequest request, HttpServletResponse response, OnIntercept onIntercept) throws IOException, ServletException {
        FilterChain filterChain = new FilterChainImpl(
                new AuthenticationFilter(onIntercept),
                new VisitorCounterFilter()
        );
        filterChain.doFilter(request, response);
    }
}
