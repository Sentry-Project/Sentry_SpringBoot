package com.sentry.Sentry.controller;

import com.sentry.Sentry.entity.Device;
import com.sentry.Sentry.service.DeviceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DeviceController {
    private DeviceService deviceService;

    public DeviceController(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @RequestMapping(value = "/getDevice" )
    @ResponseBody
    public List<Device> getDevices(@RequestParam Integer rid){
        List<Device> devices =  deviceService.findDevicesByRoomRid(rid);

        return devices;
    }

    @RequestMapping(value = "/saveDevice", method = RequestMethod.POST)
    public String saveDevice(@ModelAttribute("device") Device theDevice, @RequestParam("rid") Integer rid,
                             @RequestParam("device_name") String device_name){
        theDevice.setDeviceName(device_name);
       theDevice.setFKRoomID(rid);

        deviceService.save(theDevice);
        return "redirect:/room";
    }

    @RequestMapping(value = "/updateDeviceStatus", method = RequestMethod.POST)
    public String updateDeviceStatus(@ModelAttribute("device") Device theDevice, @RequestParam("did") Integer did)  {

        deviceService.updateDeviceStatus(did);


        return "redirect:/room";

    }


}
