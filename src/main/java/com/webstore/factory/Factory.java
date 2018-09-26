package com.webstore.factory;

import com.webstore.dao.HibernateOrderDAO;
import com.webstore.dao.OrderDAO;
import org.hibernate.SessionFactory;

import javax.persistence.Persistence;

public class Factory {
    public static final Factory INSTANCE = new Factory();

    private final SessionFactory sessionFactory;

    private Factory(){
        sessionFactory = (SessionFactory) Persistence.
                createEntityManagerFactory("org.hibernate.tutorial.jpa");
    }

    public static Factory getInstance(){return INSTANCE;}

    public OrderDAO getOrderDAO(){
        return new HibernateOrderDAO(sessionFactory);
    }

}
