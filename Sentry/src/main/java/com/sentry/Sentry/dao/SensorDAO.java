package com.sentry.Sentry.dao;

import java.util.List;

import com.sentry.Sentry.entity.Sensor;

public interface SensorDAO {
	public List<Sensor> findAll();
	public Sensor findById(int theId);

    public void save(Sensor theSensor);

}
