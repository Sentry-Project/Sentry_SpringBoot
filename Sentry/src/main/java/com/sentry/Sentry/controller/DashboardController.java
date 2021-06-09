package com.sentry.Sentry.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sentry.Sentry.entity.Device;
import com.sentry.Sentry.entity.Room;
import com.sentry.Sentry.entity.Sensor;
import com.sentry.Sentry.entity.SensorData;
import com.sentry.Sentry.entity.User;
import com.sentry.Sentry.service.RoomService;
import com.sentry.Sentry.service.SensorDataService;
import com.sentry.Sentry.service.DeviceService;

import com.sentry.Sentry.service.SensorService;
import com.sentry.Sentry.service.UserService;




@Controller
public class DashboardController {
	
	


private static UserService userService;
private SensorService sensorService;
private static SensorDataService sensorDataService;
private RoomService roomService;

private DeviceService deviceService;

public DashboardController(UserService userService,SensorService sensorService, DeviceService deviceservice, SensorDataService sensorDataService, RoomService roomservice) {
		
       this.userService = userService;
       this.sensorService = sensorService;
       this.deviceService = deviceservice;
       this.sensorDataService = sensorDataService;
       this.roomService = roomService;
       
}




	 @GetMapping("/dashboard")
	    public String displayDashboardPage(Model theModel,Authentication authentication){
		 User theUser = userService.findByUserName(authentication.getName());
		 
		 
		 
			 
		 long countsensoractive = sensorService.countactive(theUser.getId());
		 long countsensorinactive = sensorService.countinactive(theUser.getId());
		 long countsensorerror = sensorService.counterror(theUser.getId());
		 
		 long countdeviceactive = deviceService.countactive(theUser.getId());
		 long countdeviceinactive = deviceService.countinactive(theUser.getId());
		 long countdeviceerror = deviceService.counterror(theUser.getId());
		 
		 theModel.addAttribute("sensoractive", countsensoractive);
		 theModel.addAttribute("sensorinactive", countsensorinactive);
		 theModel.addAttribute("sensorerror", countsensorerror);
		 
		 theModel.addAttribute("deviceactive", countdeviceactive);
		 theModel.addAttribute("deviceinactive", countdeviceinactive);
		 theModel.addAttribute("deviceerror", countdeviceerror);
		
		 List<SensorData> sensorData = sensorDataService.sensorValueType(theUser.getId());
		 Map<SensorData,Sensor> map=new HashMap<SensorData,Sensor>();
		 Map<SensorData,String> maproomsensor =new HashMap<SensorData, String>();
		 boolean hightemperature = false;
		 boolean highgas = false;
		 boolean highwater = false;
		 
		// String[] sensortype  = new String[sensorData.size()]; 
		 theModel.addAttribute("sensor", sensorData);
		 for (int i = 0; i < sensorData.size(); i++) {
	        
	        System.out.println(sensorData.get(i));
	        Sensor sensor = sensorService.findById(sensorData.get(i).getFKSensorID());
	       // Room room = roomService.findById(sensor.getRoom().getRId());
	       // String roomname = sensor.getRoom().getrname();
	      //  sensortype[i] = sensorService.findById(sensorData.get(i).getFKSensorID()).getSensorType();
	        map.put(sensorData.get(i), sensor);
	        //maproomsensor.put(sensorData.get(i), roomname);
	        System.out.println(map.get(sensorData.get(i)).getSensorType());
	        theModel.addAttribute("sensorData", sensorData.get(i));

	if (map.get(sensorData.get(i)).getSensorType().equals("Temperature") && sensorData.get(i).getSensorValue() >= 60) {

		hightemperature = true;
		
	}
	

	if (map.get(sensorData.get(i)).getSensorType().equals("Gas") && sensorData.get(i).getSensorValue() >= 45) {

		highgas = true;
		
	}
	

	if (map.get(sensorData.get(i)).getSensorType().equals("Water") && sensorData.get(i).getSensorValue() >= 0.05) {

		highwater = true;
		
	}
	
			   System.out.println(hightemperature);}
		 
		 
		 theModel.addAttribute("sensor", sensorData);
		 theModel.addAttribute("map", map);
		 theModel.addAttribute("hightemperaturealert", "high tempreture detected");
		 theModel.addAttribute("gasalert", " gas detected");
		 theModel.addAttribute("smokealert", " smoke detected");
		 theModel.addAttribute("wateralert", "water detected");
		 theModel.addAttribute("highlevel","high");

		 theModel.addAttribute("middlelevel","middle");

		 theModel.addAttribute("lowlevel","low");
		 theModel.addAttribute("hightemperature", hightemperature);
		 theModel.addAttribute("highgas", highgas);
		 theModel.addAttribute("highwater", highwater);
		
		 
		 

		 
		 


	        return "dashboard";
	    }
	 
	 @RequestMapping(value = "/offDevice")
	   public String updateDevice(Authentication authentication){
		 
		 User theUser = userService.findByUserName(authentication.getName());
		 List<Device> alldevices = deviceService.findAll();
		 for(int i=0; i<alldevices.size();i++) {
			 alldevices.get(i).setDeviceStatus(0);
			 deviceService.save(alldevices.get(i));
		 }

	     return "redirect:/dashboard";
	   }
	 
//	 public static void main(String[]args) {
//		 
//		 List<SensorData> sensorData = sensorDataService.sensorValueType(5);
//		 int a = 0;
//		 System.out.println(sensorData);
//		 for (int i = 0; i < sensorData.size(); i++) {
//		        a++;
//		        System.out.println(sensorData.get(i));
//		        
//	 }
//		 System.out.println(a);
//	 }

}
