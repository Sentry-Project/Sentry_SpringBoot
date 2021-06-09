package com.sentry.Sentry.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sentry.Sentry.entity.Role;
import com.sentry.Sentry.entity.Room;
import com.sentry.Sentry.entity.Sensor;
import com.sentry.Sentry.entity.User;
import com.sentry.Sentry.repository.RoomRepository;


@Service
public class RoomServiceImpl implements RoomService{

	

    @Autowired
    private RoomRepository roomRepository;
    
    private List<Room> rooms;
    private Room room;
    //private List<Sensor> sensors = new ArrayList<Sensor>();


    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    
    @Override
    @Transactional
    public List<Room> findAll(int i) {
         rooms= roomRepository.findAll(i);
         return rooms;
    }


	@Override
	public void save(Room theRoom) {
		rooms.add(theRoom);
		roomRepository.save(theRoom);
		
	}

	@Override
	public Room findById(int i) {
		room = roomRepository.findById(i);
		// TODO Auto-generated method stub
		return room;
	}
    



	

}
