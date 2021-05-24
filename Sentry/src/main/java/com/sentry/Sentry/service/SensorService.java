package com.sentry.Sentry.service;

import java.util.List;

import com.sentry.Sentry.entity.Sensor;

import java.util.List;

public interface SensorService {
	public List<Sensor> findAll(int user_id);
	public long countactive(int user_id);
	public long countinactive(int user_id);
	public long counterror(int user_id);
    public void save(Sensor theSensor);
    
}


