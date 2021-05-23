package com.sentry.Sentry.service;

import java.util.List;

import com.sentry.Sentry.entity.Room;


public interface RoomService {
	
	public List<Room> findAll(int user_id);
	
	public void save(Room theRoom);
	//public Room findById(int theId);

   // public void save(Room theRoom);
}
