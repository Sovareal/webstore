package com.webstore.dao;

import com.webstore.entity.Order;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class OrderRepository implements OrderDAO {
    private final SessionFactory sessionFactory;

    public OrderRepository(SessionFactory sessionFactory) {
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
//        List<Order> result = entityManager.createQuery("from Orders", Order.class).getResultList();
        String sqlQuery = "select o from Order o";
        List<Order> result = entityManager.createQuery(sqlQuery).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public void deleteAll() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("DELETE FROM orders");
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
