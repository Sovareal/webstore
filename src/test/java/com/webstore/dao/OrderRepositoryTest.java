package com.webstore.dao;

import com.webstore.entity.Customer;
import com.webstore.entity.Order;
import com.webstore.entity.Product;
import com.webstore.factory.Factory;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class OrderRepositoryTest {

    private OrderRepository repository = new OrderRepository(Factory.getInstance().getSessionFactory());

    @Test
    public void addOrder() {
        //new customer
        Customer customer = new Customer();
        customer.setName("Aleks");
        customer.setSurname("Pupkin");

        Order order = new Order();
        order.setStatus("Paid");
        repository.addOrder(order);
        List<Order> resultList = repository.getAllOrders();
        assertTrue(resultList.get(0).getStatus().equals(order.getStatus()));
    }

    @Test
    public void getAllOrders() {
        repository.deleteAll();
        Customer customer = new Customer();
        customer.setName("Ivan");
        customer.setSurname("Sidorov");

        Order order = new Order();
        order.setStatus("Unpaid");

        Order order1 = new Order();
        order1.setStatus("Paid");

        repository.addOrder(order);
        repository.addOrder(order1);

        List<Order> orders = repository.getAllOrders();
        assertTrue(orders.size() == 2);

    }

    @Test
    public void deleteAll() {
    }
}