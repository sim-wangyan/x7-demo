package io.sim.demo.x7.service;

import io.sim.demo.x7.entity.Order;

/**
 * @Author Sim
 */
public interface OrderService {
    long createId();
    boolean create(Order order);
    boolean refresh(Order order);
    boolean remove(long id);
}
