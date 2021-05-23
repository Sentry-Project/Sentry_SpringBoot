package com.sentry.Sentry.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sentry.Sentry.entity.Room;
import com.sentry.Sentry.entity.Sensor;
import com.sentry.Sentry.entity.User;
import com.sentry.Sentry.service.RoomService;
import com.sentry.Sentry.service.SensorService;
import com.sentry.Sentry.service.UserService;
import com.sentry.Sentry.web.dto.UserRegistrationDto;



@Controller
public class RoomController {
	
	 private RoomService roomService;
	 private UserService userService;
	 private SensorService sensorService;
	  
	 
	 public RoomController(RoomService roomService,UserService userService,SensorService sensorService) {
	        this.roomService = roomService;
	        this.userService = userService;
	        this.sensorService = sensorService;
	 }
	 
	 
	  @ModelAttribute("room")
	    public Room room(){
	        return new Room();
	    }
	
	 @GetMapping("/room")
	 public String  displayRoomPage(Model theModel,Authentication authentication){
	     User theUser = userService.findByUserName(authentication.getName());
		 List<Room> room = roomService.findAll(theUser.getId());
			 for (int i = 0; i < room.size(); i++) {
		        theModel.addAttribute("room", room.get(i));
		       }
			 theModel.addAttribute("strings", room);
	     return "room";
	  }
	 
	//button-add a new room
     @PostMapping("/addoneroom")
     public String saveroom(@ModelAttribute("room") Room theRoom,Authentication authentication){
    	    User theUser = userService.findByUserName(authentication.getName());
			theRoom.setuser_id(theUser.getId());
	
		    //List<Sensor> sensors = new ArrayList<Sensor>();
			//Sensor s = new Sensor("Tempeartrue","Tempeartrue","C");
        	//sensors.add(s);
        	
        	//theRoom.setsensor(sensors);
        	
		    roomService.save(theRoom);	
			
			Sensor s1 = new Sensor("Tempeartrue","TempeartrueSensor","celsius");
			s1.setRoom(theRoom);
			sensorService.save(s1);
			
			Sensor s2 = new Sensor("Gas","COSensor","ppm");
			s2.setRoom(theRoom);
			sensorService.save(s2);
			
			Sensor s3 = new Sensor("Water","waterSensor","m^3");
			s3.setRoom(theRoom);
			sensorService.save(s3);
		
		    //redirect
		    return "redirect:/room";
	  }
	 

}
