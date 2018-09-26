package com.webstore.dao;

import com.webstore.entity.Order;

import java.util.List;

public interface OrderDAO {

    void addOrder(Order order);

    List<Order> getAllOrders();

    void deleteAll();


}
