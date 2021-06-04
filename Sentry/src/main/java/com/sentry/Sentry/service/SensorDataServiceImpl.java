package com.sentry.Sentry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sentry.Sentry.entity.Sensor;
import com.sentry.Sentry.entity.SensorData;
import com.sentry.Sentry.repository.SensorDataRepository;
import com.sentry.Sentry.repository.SensorRepository;

@Service
public class SensorDataServiceImpl implements SensorDataService{
	
	private SensorRepository sensorRepository;
	
	@Autowired
	private SensorDataRepository sensorDataRepository;
	
	private List<Sensor> sensors;
	private List<SensorData> sensorValueType;

	
	public SensorDataServiceImpl (SensorDataRepository sensorDataRepository){
		this.sensorDataRepository=sensorDataRepository;	
		
	}
	@Override
	public List<SensorData> sensorValueType(int i) {
		sensorValueType = sensorDataRepository.sensorValueType(i);
		return sensorValueType;
	}
	
	
	

	@Override
	public List<Sensor> findAll(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SensorData> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SensorData findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(SensorData theSensorData) {
		// TODO Auto-generated method stub
		
	}

}
