package com.sentry.Sentry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sentry.Sentry.entity.Sensor;
import com.sentry.Sentry.repository.SensorRepository;

@Service
public class SensorServiceImpl implements SensorService{

	private SensorRepository sensorRepository;

	 @Autowired
	 public SensorServiceImpl(SensorRepository sensorRepository){
		 this.sensorRepository = sensorRepository;
	 }


	@Override
    @Transactional
	public void save(Sensor theSensor) {
		sensorRepository.save(theSensor);

	}

}
