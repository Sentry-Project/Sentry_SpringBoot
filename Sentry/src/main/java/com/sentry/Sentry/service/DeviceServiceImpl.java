package com.sentry.Sentry.service;

import com.sentry.Sentry.dao.DeviceDAO;
import com.sentry.Sentry.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService{

    private DeviceDAO deviceDAO;

    @Autowired
    public DeviceServiceImpl(DeviceDAO theDeviceDAO){
        deviceDAO = theDeviceDAO;
    }

    @Override
    @Transactional
    public List<Device> findAll() {
        return deviceDAO.findAll();
    }

    @Override
    @Transactional
    public Device findById(int theId) {
        return deviceDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Device theDevice) {
        deviceDAO.save(theDevice);
    }
}
