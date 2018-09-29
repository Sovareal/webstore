package com.webstore.factory;

import org.hibernate.SessionFactory;

import javax.persistence.Persistence;

public class Factory {
    private static final Factory INSTANCE = new Factory();

    private final SessionFactory sessionFactory;

    private Factory() {
        sessionFactory = (SessionFactory) Persistence.
                createEntityManagerFactory("org.hibernate.tutorial.jpa");
    }

    public static Factory getInstance() {
        return INSTANCE;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
