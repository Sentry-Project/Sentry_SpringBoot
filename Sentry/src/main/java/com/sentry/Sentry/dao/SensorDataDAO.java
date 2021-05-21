package com.sentry.Sentry.dao;

import java.util.List;

import com.sentry.Sentry.entity.SensorData;

public interface SensorDataDAO {
	public List<SensorData> findAll();
	public SensorData findById(int theId);

    public void save(SensorData theSensorData);

}
