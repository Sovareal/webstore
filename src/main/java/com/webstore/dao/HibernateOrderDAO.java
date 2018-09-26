package com.webstore.dao;

import com.webstore.entity.Order;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class HibernateOrderDAO implements OrderDAO {
    private final SessionFactory sessionFactory;

    public HibernateOrderDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    public void addOrder(Order order) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Order> getAllOrders() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Order> result = entityManager.createQuery("from Customer", Order.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public void deleteAll() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("DELETE FROM customers");
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
