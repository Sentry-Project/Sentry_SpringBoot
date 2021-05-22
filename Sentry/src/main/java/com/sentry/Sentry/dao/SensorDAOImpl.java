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
//import com.sentry.Sentry.entity.Sensor;
//
//@Repository
//public class SensorDAOImpl implements SensorDAO{
//
//    //define field for entity manager
//    private EntityManager entityManager;
//
//    //set up constructor injection
//    @Autowired
//    public SensorDAOImpl(EntityManager theEntityManager){
//        entityManager = theEntityManager;
//    }
//	@Override
//	public List<Sensor> findAll() {
//		//get hibernate session
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        //create query
//        Query<Sensor> theQuery =
//                currentSession.createQuery("from Sensor", Sensor.class);
//        //execute query and get result
//        List<Sensor> sensors = theQuery.getResultList();
//
//        //return result
//		return sensors;
//	}
//
//	@Override
//	public Sensor findById(int theId) {
//		//get hibernate session
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        //get device
//        Sensor theSensor =
//                currentSession.get(Sensor.class, theId);
//
//        //return device
//        return theSensor;
//	}
//
//	@Override
//	public void save(Sensor theSensor) {
//
//		//get current session
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        //save device
//        currentSession.saveOrUpdate(theSensor);
//	}
//
//}
