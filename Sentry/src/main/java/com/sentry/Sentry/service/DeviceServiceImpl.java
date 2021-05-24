package com.sentry.Sentry.service;


import com.sentry.Sentry.entity.Device;
import com.sentry.Sentry.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;




@Service
public class DeviceServiceImpl implements DeviceService{


    
private DeviceRepository deviceRepository;
	
	private List<Device> devices;
	private long countsensorsactive;
	private long countsensorsinactive;
	private long countsensorserror;

	
	 
	 
    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository){
        this.deviceRepository = deviceRepository;
    }
    
    
    
    public long countactive(int i) {
		countsensorsactive= deviceRepository.countactive(i);
		// TODO Auto-generated method stub
		return countsensorsactive;
	}
	
	public long countinactive(int i) {
		countsensorsinactive= deviceRepository.countinactive(i);
		// TODO Auto-generated method stub
		return countsensorsinactive;
	}
	
	
	public long counterror(int i) {
		countsensorserror= deviceRepository.counterror(i);
		// TODO Auto-generated method stub
		return countsensorserror;
	}


	

    @Override
    @Transactional
    public List<Device> findAll() {
        return deviceRepository.findAll();
    }



    @Override
    @Transactional
    public void save(Device theDevice) {
        deviceRepository.save(theDevice);
    }



	@Override
	public Device findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}
}



