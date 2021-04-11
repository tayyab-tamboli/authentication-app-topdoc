package com.topdoc.exercise.authenticationapp.filter;

import com.topdoc.exercise.authenticationapp.services.impl.UserAppService;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author TAYYAB
 */
@Configuration
public class RestAuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (httpRequest.getRequestURL().indexOf("/profile") != -1) {
            String token = httpRequest.getHeader("auth-token");
            Calendar now = Calendar.getInstance();
            if (!StringUtils.isEmpty(token) && UserAppService.authUsers.containsKey(token)
                    && UserAppService.authUsers.get(token).getExpiryTime().after(now)) {
                chain.doFilter(request, response);
            } else {
                HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
            }
        } else if (httpRequest.getRequestURL().indexOf("/logout") != -1) {
            String token = httpRequest.getHeader("auth-token");
            Calendar now = Calendar.getInstance();
            if (!StringUtils.isEmpty(token) && UserAppService.authUsers.containsKey(token)
                    && UserAppService.authUsers.get(token).getExpiryTime().after(now)) {
                UserAppService.authUsers.remove(token);
                chain.doFilter(request, response);
            }
        } else
            chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
