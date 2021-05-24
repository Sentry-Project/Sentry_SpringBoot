package com.sentry.Sentry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sentry.Sentry.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
	
	@Query(value="select * from room where room.FK_USER_ID = ?1",nativeQuery=true)
	 List<Room> findAll(int user_id);

	//Room 

}
