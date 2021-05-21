package com.sentry.Sentry.service;

import com.sentry.Sentry.entity.SensorData;

import java.util.List;

public interface SensorDataService {
    public List<SensorData> findAll();
    public SensorData findById(int theId);

    public void save(SensorData theSensorData);
}
