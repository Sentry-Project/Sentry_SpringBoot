package com.sentry.Sentry.controller;

import com.sentry.Sentry.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String displayHomePage(){
        return "index";
    }

  //Login
    @RequestMapping("/login")
	public String showLoginPage() {
		return "login"; 
	}
  //signup
    @RequestMapping("/signup")
	public String showSignUpPage() {
		return "signup"; 
	}

}
