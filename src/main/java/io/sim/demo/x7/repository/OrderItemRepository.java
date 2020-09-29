package io.sim.demo.x7.repository;

import io.sim.demo.x7.entity.OrderItem;
import io.xream.sqli.api.BaseRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderItemRepository extends BaseRepository<OrderItem>{
}
