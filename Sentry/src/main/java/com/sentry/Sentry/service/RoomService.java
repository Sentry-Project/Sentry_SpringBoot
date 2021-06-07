package com.sentry.Sentry.service;

import java.util.List;

import com.sentry.Sentry.entity.Room;
import com.sentry.Sentry.entity.Sensor;


public interface RoomService {
	
	public List<Room> findAll(int user_id);
	
	public void save(Room theRoom);
	//public Room findById(int theId);
	Room findById(int i);
   // public void save(Room theRoom);
}
