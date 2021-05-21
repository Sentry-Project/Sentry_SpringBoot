package com.sentry.Sentry.dao;

import com.sentry.Sentry.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    //define field for entity manager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public UserDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<User> findAll() {
        //get hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //create query
        Query<User> theQuery =
                currentSession.createQuery("from User", User.class);
        //execute query and get result
        List<User> users = theQuery.getResultList();
        //return result
        return users;
    }

    @Override
    public User findById(int theId) {
        //get hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //get user
        User theUser =
                currentSession.get(User.class, theId);

        //return user
        return theUser;
    }

    @Override
    public void save(User theUser) {
        //get current session
        Session currentSession = entityManager.unwrap(Session.class);

        //save user
        currentSession.saveOrUpdate(theUser);

    }
}
