//package com.sentry.Sentry.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.sentry.Sentry.dao.RoomDAO;
//import com.sentry.Sentry.entity.Room;
//
//@Service
//public class RoomServiceImpl implements RoomService{
//
//	private RoomDAO roomDAO;
//
//	 @Autowired
//	 public RoomServiceImpl(RoomDAO theRoomDAO){
//		 roomDAO = theRoomDAO;
//	    }
//
//	@Override
//    @Transactional
//	public List<Room> findAll() {
//
//		return roomDAO.findAll();
//
//	}
//
//	@Override
//    @Transactional
//	public Room findById(int theId) {
//		 return roomDAO.findById(theId);
//	}
//
//	@Override
//    @Transactional
//	public void save(Room theRoom) {
//		roomDAO.save(theRoom);
//
//	}
//
//}
