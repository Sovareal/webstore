package com.webstore.main;

import com.webstore.dao.OrderDAO;
import com.webstore.dao.OrderRepository;
import com.webstore.entity.Order;
import com.webstore.entity.Product;
import com.webstore.factory.Factory;

public class Main {
    public static void main(String[] args) {
        Factory factory = Factory.getInstance();
        OrderDAO orderDAO = new OrderRepository(factory.getSessionFactory());
        Order order = new Order();
        order.setProduct(new Product());

        orderDAO.addOrder(order);
    }
}
