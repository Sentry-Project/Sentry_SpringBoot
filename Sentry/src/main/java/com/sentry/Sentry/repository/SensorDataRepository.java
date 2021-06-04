package com.sentry.Sentry.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sentry.Sentry.entity.Room;
import com.sentry.Sentry.entity.Sensor;
import com.sentry.Sentry.entity.SensorData;

public interface SensorDataRepository extends JpaRepository<SensorData, Integer> {


	@Query(value="Select ID,SENSOR_STATUS,TIMESTAMP,FK_SENSOR_ID,SENSOR_VALUE,ROOM_NAME from sensor_data JOIN sensor ON FK_SENSOR_ID = SENSOR_ID JOIN room ON FK_ROOM_ID = ROOM_ID WHERE FK_ROOM_ID IN ( SELECT ROOM_ID FROM room WHERE FK_USER_ID = ?1)",nativeQuery=true)
    List<SensorData> sensorValueType(int user_id);

	
	//for room page
	//get sensor,sensordata for one room
	@Query(value="Select sd.* from sensor_data sd JOIN sensor s on sd.FK_SENSOR_ID=s.SENSOR_ID\n"
			+ "JOIN room r On s.FK_ROOM_ID = r.ROOM_ID\n"
			+ "WHERE ROOM_ID= ?1",nativeQuery=true)
	List<SensorData>findSensorDataByRoomRid(int rid);

}




