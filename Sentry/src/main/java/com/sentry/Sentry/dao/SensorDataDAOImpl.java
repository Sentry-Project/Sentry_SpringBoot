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
//import com.sentry.Sentry.entity.SensorData;
//
//@Repository
//public class SensorDataDAOImpl implements SensorDataDAO{
//
//    //define field for entity manager
//    private EntityManager entityManager;
//
//    //set up constructor injection
//    @Autowired
//    public SensorDataDAOImpl(EntityManager theEntityManager){
//        entityManager = theEntityManager;
//    }
//	@Override
//	public List<SensorData> findAll() {
//		//get hibernate session
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        //create query
//        Query<SensorData> theQuery =
//                currentSession.createQuery("from Sensor_Data", SensorData.class);
//        //execute query and get result
//        List<SensorData> sensordatas = theQuery.getResultList();
//
//        //return result
//		return sensordatas;
//	}
//
//	@Override
//	public SensorData findById(int theId) {
//		//get hibernate session
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        //get device
//        SensorData theSensorData =
//                currentSession.get(SensorData.class, theId);
//
//        //return device
//        return theSensorData;
//	}
//
//	@Override
//	public void save(SensorData theSensorData) {
//
//		//get current session
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        //save device
//        currentSession.saveOrUpdate(theSensorData);
//	}
//
//}
