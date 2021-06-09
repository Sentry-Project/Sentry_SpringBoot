package com.sentry.Sentry.controller;

import com.sentry.Sentry.entity.Sensor;
import com.sentry.Sentry.entity.SensorData;
import com.sentry.Sentry.service.SensorDataService;
import com.sentry.Sentry.service.SensorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SensorController {

    private SensorService sensorService;
    private SensorDataService sensordataService;

    public SensorController(SensorService sensorService,SensorDataService sensordataService) {
        this.sensorService = sensorService;
        this.sensordataService = sensordataService;
    }


    @RequestMapping(value = "/getSensor" )
    @ResponseBody
    public List<Sensor> getSensors(@RequestParam Integer rid){
        List<Sensor> sensors =  sensorService.findSensorsByRoomRid(rid);

        return sensors;
    }
    
    @RequestMapping(value = "/getSensorData" )
    @ResponseBody
    public List<SensorData> getSensorData(@RequestParam Integer rid){
        List<SensorData> sensord =  sensordataService.findSensorDataByRoomRid(rid);

        return sensord;
    }


}
