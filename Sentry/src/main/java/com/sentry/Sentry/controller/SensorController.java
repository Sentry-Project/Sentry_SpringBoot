package com.sentry.Sentry.controller;

import com.sentry.Sentry.entity.Sensor;
import com.sentry.Sentry.service.SensorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SensorController {

    private SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }


    @RequestMapping(value = "/getSensor" )
    @ResponseBody
    public List<Sensor> getSensors(@RequestParam Integer rid){
        List<Sensor> sensors =  sensorService.findSensorsByRoomRid(rid);

        return sensors;
    }


}
