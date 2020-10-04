package io.sim.demo.x7.entity;

import io.xream.sqli.annotation.X;

public class OrderLog {

    @X.Key
    private Long id;
    private Long orderId;
    private String log;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
