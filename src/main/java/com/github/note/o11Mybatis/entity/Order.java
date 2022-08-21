package com.github.note.o11Mybatis.entity;

import java.math.BigDecimal;

public class Order {
    private Integer id;
    private User user;
    private Goods goods;
    private BigDecimal totalPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", user=" + user + ", goods=" + goods + ", totalPrice=" + totalPrice + '}';
    }
}
