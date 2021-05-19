package com.sentry.Sentry.controller;

import com.sentry.Sentry.dao.UserDAO;
import com.sentry.Sentry.entity.User;
import com.sentry.Sentry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
//@RequestMapping("/dashboard")
public class UserController {

    private UserService userService;

  

    
    //inject user dao
    @Autowired
    public UserController(UserService theUserService){
        userService= theUserService;
    }

    /*setting page*/
    /*show information*/
    @RequestMapping("/setting")
	public String showSettingPage(Model theModel) {
    	User theUser = userService.findById(5);
        theModel.addAttribute("user", theUser);
        
		return "setting"; 
	}    
   /*update the form of setting page*/
    @PostMapping("/update")
    public String updateSettingForm(@ModelAttribute("user") User theUser){
    	theUser.setId(5);
        userService.save(theUser);
        //redirect
        return "setting";
    }
    
    

    @GetMapping("/sample")
    public String sampleForm(Model theModel){
        //create model attribute to bind form data
        User theUser = new User();
        theModel.addAttribute("user", theUser);

        return "sample";
    }

    @GetMapping("/sample2")
    public String displayData(Model theModel){
        //create model attribute to bind form data
        User theUser = userService.findById(6);
        theModel.addAttribute("user", theUser);

        return "sample2";
    }

    @PostMapping("/save")
    public String saveSampleForm(@ModelAttribute("user") User theUser){
        //save user
        userService.save(theUser);
        //redirect
        return "redirect:/";
    }

    //expose /users to return list of user (--can use this as sample for get devices)
//    @GetMapping("/users")
//    public List<User> findAll(){
//        return userService.findAll();
//    }
//
//    @GetMapping("/users/{userId}")
//    public User getUser(@PathVariable int userId){
//        User theUser = userService.findById(userId);
//        if (theUser == null){
//            throw new RuntimeException("User Id not found " + userId);
//        }
//        return theUser;
//    }
}
