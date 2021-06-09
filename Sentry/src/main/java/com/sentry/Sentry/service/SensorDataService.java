package com.sentry.Sentry.service;

import com.sentry.Sentry.entity.Sensor;
import com.sentry.Sentry.entity.SensorData;

import java.util.List;

public interface SensorDataService {

	public List<Sensor> findAll(int user_id);
	public List<SensorData> sensorValueType(int user_id);
	
    public List<SensorData> findAll();
    public SensorData findById(int theId);

    public void save(SensorData theSensorData);
    
    public List<SensorData>findSensorDataByRoomRid(int rid);
}
