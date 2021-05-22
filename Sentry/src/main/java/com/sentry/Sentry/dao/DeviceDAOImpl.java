//package com.sentry.Sentry.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import org.hibernate.Session;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.sentry.Sentry.entity.Device;
//
//@Repository
//public class DeviceDAOImpl implements DeviceDAO{
//
//    //define field for entity manager
//    private EntityManager entityManager;
//
//    //set up constructor injection
//    @Autowired
//    public DeviceDAOImpl(EntityManager theEntityManager){
//        entityManager = theEntityManager;
//    }
//	@Override
//	public List<Device> findAll() {
//		//get hibernate session
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        //create query
//        Query<Device> theQuery =
//                currentSession.createQuery("from Device", Device.class);
//        //execute query and get result
//        List<Device> devices = theQuery.getResultList();
//
//        //return result
//		return devices;
//	}
//
//	@Override
//	public Device findById(int theId) {
//		//get hibernate session
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        //get device
//        Device theDevice =
//                currentSession.get(Device.class, theId);
//
//        //return device
//        return theDevice;
//	}
//
//	@Override
//	public void save(Device theDevice) {
//
//		//get current session
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        //save device
//        currentSession.saveOrUpdate(theDevice);
//	}
//
//}
