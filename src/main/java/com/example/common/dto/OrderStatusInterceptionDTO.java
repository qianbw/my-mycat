package com.example.common.dto;

public class OrderStatusInterceptionDTO extends BaseDTO {

    private String orderStatus;

    private String statusInterception;

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStatusInterception() {
        return statusInterception;
    }

    public void setStatusInterception(String statusInterception) {
        this.statusInterception = statusInterception;
    }
}
