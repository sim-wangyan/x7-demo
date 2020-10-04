package io.sim.demo.x7;


import io.sim.demo.x7.controller.OmsController;
import io.sim.demo.x7.controller.OrderController;
import io.sim.demo.x7.entity.OrderType;
import io.sim.demo.x7.ro.FindRo;
import io.sim.demo.x7.ro.OrderRo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {

    @Autowired
    private OrderController orderController;

    @Autowired
    private OmsController omsController;

    @Test
    public void testAll(){

        OrderRo ro = new OrderRo();
        ro.setName("WAAA");
        ro.setType(OrderType.PING);
        ro.setUserId(1);

        orderController.create(ro);

        OrderRo refresh = new OrderRo();
        refresh.setType(OrderType.SINGLE);
        refresh.setId(7);

        orderController.refresh(refresh);

        orderController.remove(8);

        omsController.find(new FindRo());
    }

}
