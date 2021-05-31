package com.sentry.Sentry.controller;

import com.sentry.Sentry.entity.Device;
import com.sentry.Sentry.entity.Sensor;
import com.sentry.Sentry.service.DeviceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
