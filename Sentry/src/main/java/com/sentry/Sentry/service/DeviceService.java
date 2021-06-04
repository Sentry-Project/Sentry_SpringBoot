package com.sentry.Sentry.service;

import com.sentry.Sentry.entity.Device;

import java.util.List;

public interface DeviceService {
    public List<Device> findAll();
    List<Device> findDevicesByRoomRid(int rid);
    public Device findById(int theId);
    public long countactive(int user_id);
	public long countinactive(int user_id);
	public long counterror(int user_id);
    public void save(Device theDevice);
}
