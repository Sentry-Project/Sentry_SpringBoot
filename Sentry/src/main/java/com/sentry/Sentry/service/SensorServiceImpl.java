package com.sentry.Sentry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sentry.Sentry.dao.SensorDAO;
import com.sentry.Sentry.entity.Sensor;

@Service
public class SensorServiceImpl implements SensorService{
	
	private SensorDAO sensorDAO;
	
	 @Autowired
	 public SensorServiceImpl(SensorDAO theSensorDAO){
		 sensorDAO = theSensorDAO;
	    }

	@Override
    @Transactional
	public List<Sensor> findAll() {
		 
		return sensorDAO.findAll();

	}

	@Override
    @Transactional
	public Sensor findById(int theId) {
		 return sensorDAO.findById(theId);
	}

	@Override
    @Transactional
	public void save(Sensor theSensor) {
		sensorDAO.save(theSensor);
		
	}

}
