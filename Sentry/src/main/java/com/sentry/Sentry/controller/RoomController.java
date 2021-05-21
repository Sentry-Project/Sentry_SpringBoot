package com.sentry.Sentry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sentry.Sentry.entity.Room;
import com.sentry.Sentry.service.RoomService;

@Controller
public class RoomController {
	private RoomService roomService;


	 	 
    //inject room dao
    @Autowired
    public RoomController(RoomService theRoomService){
    	roomService= theRoomService;
    }
    
    
	 @GetMapping("/room")
	 public String  displayRoomPage(Model theModel){
		 List<Room> room = roomService.findAll();
		 for (int i = 0; i < room.size(); i++) {
	        theModel.addAttribute("room", room.get(i));
	       }
		 theModel.addAttribute("strings", room);
	     return "room";
	  }

	 //button-add a new room
	 @PostMapping("/addoneroom")
	 public String saveroom(@ModelAttribute("room") Room theRoom){
		 
		   theRoom.setuserid(5);
	       roomService.save(theRoom);	    	
	        //redirect
	      return "redirect:/room";
    }


}
