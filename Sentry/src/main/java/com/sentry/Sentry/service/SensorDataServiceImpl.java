package com.sentry.Sentry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sentry.Sentry.dao.SensorDataDAO;
import com.sentry.Sentry.entity.SensorData;

@Service
public class SensorDataServiceImpl implements SensorDataService{
	
	private SensorDataDAO sensorDataDAO;
	
	 @Autowired
	 public SensorDataServiceImpl(SensorDataDAO theSensorDataDAO){
		 sensorDataDAO = theSensorDataDAO;
	    }

	@Override
    @Transactional
	public List<SensorData> findAll() {
		 
		return sensorDataDAO.findAll();

	}

	@Override
    @Transactional
	public SensorData findById(int theId) {
		 return sensorDataDAO.findById(theId);
	}

	@Override
    @Transactional
	public void save(SensorData theSensorData) {
		sensorDataDAO.save(theSensorData);
		
	}

}
