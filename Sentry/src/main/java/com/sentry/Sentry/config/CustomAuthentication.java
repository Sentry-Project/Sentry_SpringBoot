package com.sentry.Sentry.config;

import com.sentry.Sentry.entity.User;
import com.sentry.Sentry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomAuthentication implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String userName = authentication.getName();
        User theUser = userService.findByUserName(userName);

        //place in session
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("user", theUser);

        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/dashboard");

    }
}
