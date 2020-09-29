package io.sim.demo.x7.ro;

import io.sim.demo.x7.entity.OrderType;
import io.xream.x7.base.web.TokenedAndPagedRo;

/**
 * @Author Sim
 */
public class FindRo extends TokenedAndPagedRo {

    private long startTime;
    private long endTime;
    private OrderType orderType;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

}
