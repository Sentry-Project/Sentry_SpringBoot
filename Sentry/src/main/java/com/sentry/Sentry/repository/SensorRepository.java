package com.sentry.Sentry.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sentry.Sentry.entity.Room;

import com.sentry.Sentry.entity.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {




	@Query(value="Select * from sensor WHERE FK_ROOM_ID IN ( SELECT ROOM_ID FROM room WHERE FK_USER_ID = ?1)",nativeQuery=true)
	 List<Sensor> findAll(int user_id);

	//Room

	@Query(value="Select count(*) from sensor_data WHERE SENSOR_STATUS = 1 AND FK_SENSOR_ID IN (Select SENSOR_ID from sensor WHERE FK_ROOM_ID IN ( SELECT ROOM_ID FROM room WHERE FK_USER_ID = ?1))",nativeQuery=true)
	 long countactive(int user_id);
	
	@Query(value="Select count(*) from sensor_data WHERE SENSOR_STATUS = 0 AND FK_SENSOR_ID IN (Select SENSOR_ID from sensor WHERE FK_ROOM_ID IN ( SELECT ROOM_ID FROM room WHERE FK_USER_ID = ?1))",nativeQuery=true)
	 long countinactive(int user_id);
	
	@Query(value="Select count(*) from sensor_data WHERE SENSOR_STATUS = -1 AND FK_SENSOR_ID IN (Select SENSOR_ID from sensor WHERE FK_ROOM_ID IN ( SELECT ROOM_ID FROM room WHERE FK_USER_ID = ?1))",nativeQuery=true)
	 long counterror(int user_id);


}




