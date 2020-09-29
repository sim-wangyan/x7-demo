package io.sim.demo.x7.ro;

import io.sim.demo.x7.entity.OrderType;
import io.xream.x7.base.web.TokenedRo;

/**
 * @Author Sim
 */
public class OrderRo extends TokenedRo {

    private long id;
    private String name;
    private long createAt;
    private OrderType type;
    private long userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "OrderRo{" +
                "name='" + name + '\'' +
                ", createAt=" + createAt +
                ", type=" + type +
                ", userId=" + userId +
                '}';
    }
}
