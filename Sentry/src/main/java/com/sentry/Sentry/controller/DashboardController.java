package com.sentry.Sentry.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sentry.Sentry.entity.Room;
import com.sentry.Sentry.entity.User;
import com.sentry.Sentry.service.RoomService;
import com.sentry.Sentry.service.SensorService;
import com.sentry.Sentry.service.UserService;




@Controller
public class DashboardController {
	
	


private UserService userService;
private SensorService sensorService;
 

public DashboardController(UserService userService,SensorService sensorService) {
  
       this.userService = userService;
       this.sensorService = sensorService;
}




	 @GetMapping("/dashboard")
	    public String displayDashboardPage(Model theModel,Authentication authentication){
		 User theUser = userService.findByUserName(authentication.getName());
		 long countsensoractive = sensorService.countactive(theUser.getId());
		 long countsensorinactive = sensorService.countinactive(theUser.getId());
		 long countsensorerror = sensorService.counterror(theUser.getId());
		 theModel.addAttribute("sensoractive", countsensoractive);
		 theModel.addAttribute("sensorinactive", countsensorinactive);
		 theModel.addAttribute("sensorerror", countsensorerror);
	        return "dashboard";
	    }

}
