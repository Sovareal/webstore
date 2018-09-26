package com.webstore.main;

import com.webstore.dao.OrderDAO;
import com.webstore.entity.Order;
import com.webstore.factory.Factory;

public class Main {
    public static void main(String[] args) {
        Factory factory = Factory.getInstance();
        OrderDAO orderDAO = factory.getOrderDAO();
        Order order = new Order();
        orderDAO.addOrder(order);
    }
}
