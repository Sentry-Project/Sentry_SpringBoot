package com.sentry.Sentry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sentry.Sentry.entity.Room;

import com.sentry.Sentry.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer> {




	@Query(value="Select * from device WHERE FK_ROOM_ID IN ( SELECT ROOM_ID FROM room WHERE FK_USER_ID = ?1)",nativeQuery=true)
	 List<Device> findAll(int user_id);

	//Room

	@Query(value="Select count(*) from device WHERE  DEVICE_STATUS = 1 AND FK_ROOM_ID IN ( SELECT ROOM_ID FROM room WHERE FK_USER_ID = ?1)",nativeQuery=true)
	 long countactive(int user_id);

	@Query(value="Select count(*) from device WHERE  DEVICE_STATUS = 0 AND FK_ROOM_ID IN ( SELECT ROOM_ID FROM room WHERE FK_USER_ID = ?1)",nativeQuery=true)
	 long countinactive(int user_id);

	@Query(value="Select count(*) from device WHERE  DEVICE_STATUS = -1 AND FK_ROOM_ID IN ( SELECT ROOM_ID FROM room WHERE FK_USER_ID = ?1)",nativeQuery=true)
	 long counterror(int user_id);

	@Query(value="Select * from device WHERE FK_ROOM_ID= ?1",nativeQuery=true)
    List<Device> findDevicesByRoomRid(int rid);
}