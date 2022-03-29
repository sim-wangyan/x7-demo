package io.sim.demo.x7.service;

import io.sim.demo.x7.entity.Order;
import io.sim.demo.x7.repository.OrderRepository;
import io.xream.sqli.builder.RefreshBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Sim
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public long createId() {
        return this.orderRepository.createId();
    }

    @Override
    public boolean create(Order order) {
        return this.orderRepository.create(order);
    }

    @Override
    public boolean refresh(Order order) {
        return this.orderRepository.refresh(
                RefreshBuilder.builder().refresh("type",order.getType()).eq("id",order.getId()).build()
        );
    }

    @Override
    public boolean remove(long id) {
        return this.orderRepository.remove(id);
    }
}
