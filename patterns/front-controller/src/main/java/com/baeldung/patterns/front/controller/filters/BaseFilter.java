package com.baeldung.patterns.front.controller.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

public abstract class BaseFilter implements Filter {
    private Logger log = LoggerFactory.getLogger(BaseFilter.class);

    protected FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Initialize filter: {}", getClass().getSimpleName());
    }

    @Override
    public void destroy() {
        log.info("Destroy filter: {}", getClass().getSimpleName());
    }
}
