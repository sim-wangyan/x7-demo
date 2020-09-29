package io.sim.demo.x7.controller;

import io.sim.demo.x7.entity.Order;
import io.sim.demo.x7.ro.OrderRo;
import io.sim.demo.x7.service.OrderService;
import io.xream.x7.base.web.ViewEntity;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Sim
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/create")
    public ViewEntity create(@RequestBody OrderRo ro) {

        Order order = new Order();
        try {
            BeanUtils.copyProperties(order, ro);
        }catch (Exception e){

        }
        long id = this.orderService.createId();
        order.setId(id);
        order.setCreateAt(System.currentTimeMillis());

        this.orderService.create(order);

        return ViewEntity.ok(order);
    }

    @RequestMapping("/refresh")
    public ViewEntity refresh(@RequestBody OrderRo ro) {

        Order order = new Order();
        try {
            BeanUtils.copyProperties(order, ro);
        }catch (Exception e){

        }

        this.orderService.refresh(order);

        return ViewEntity.ok(order);
    }

    @RequestMapping("/remove")
    public ViewEntity remove(@RequestBody long id) {

        this.orderService.remove(id);

        return ViewEntity.ok();
    }

}
