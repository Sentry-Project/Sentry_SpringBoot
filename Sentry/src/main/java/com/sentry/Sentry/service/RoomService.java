package com.sentry.Sentry.service;

import java.util.List;

import com.sentry.Sentry.entity.Room;

public interface RoomService {
	public List<Room> findAll();
	public Room findById(int theId);

    public void save(Room theRoom);
}
