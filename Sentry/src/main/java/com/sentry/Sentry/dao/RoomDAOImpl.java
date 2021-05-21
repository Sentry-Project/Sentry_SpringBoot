package com.sentry.Sentry.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sentry.Sentry.entity.Room;

@Repository
public class RoomDAOImpl implements RoomDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public RoomDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
	@Override
	public List<Room> findAll() {
		//get hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //create query
        Query<Room> theQuery =
                currentSession.createQuery("from Room", Room.class);
        //execute query and get result
        List<Room> rooms = theQuery.getResultList();

        //return result
		return rooms;
	}

	@Override
	public Room findById(int theId) {
		//get hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //get user
        Room theRoom =
                currentSession.get(Room.class, theId);

        //return user
        return theRoom;
	}

	@Override
	public void save(Room theRoom) {
	
		//get current session
        Session currentSession = entityManager.unwrap(Session.class);

        //save user
        currentSession.saveOrUpdate(theRoom);
	}

}
