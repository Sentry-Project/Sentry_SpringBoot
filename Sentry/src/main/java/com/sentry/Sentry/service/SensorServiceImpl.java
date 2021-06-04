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
	
	private List<Sensor> sensors;
	private long countsensorsactive;
	private long countsensorsinactive;
	private long countsensorserror;
	 @Autowired
	 public SensorServiceImpl(SensorRepository sensorRepository){
		 this.sensorRepository = sensorRepository;
	 }


	@Override
    @Transactional
	public void save(Sensor theSensor) {
		sensorRepository.save(theSensor);

	}


	@Override
	public List<Sensor> findAll(int i) {
		sensors= sensorRepository.findAll(i);
		// TODO Auto-generated method stub
		return sensors;
	}

	@Override
	public List<Sensor> findSensorsByRoomRid(int rid) {
		sensors = sensorRepository.findSensorsByRoomRid(rid);
		return sensors;
	}

	public long countactive(int i) {
		countsensorsactive= sensorRepository.countactive(i);
		// TODO Auto-generated method stub
		return countsensorsactive;
	}
	
	public long countinactive(int i) {
		countsensorsinactive= sensorRepository.countinactive(i);
		// TODO Auto-generated method stub
		return countsensorsinactive;
	}
	
	
	public long counterror(int i) {
		countsensorserror= sensorRepository.counterror(i);
		// TODO Auto-generated method stub
		return countsensorserror;
	}
}
