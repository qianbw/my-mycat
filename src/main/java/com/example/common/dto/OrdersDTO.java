package com.example.common.dto;

import java.sql.Timestamp;

public class OrdersDTO extends BaseDTO {
    private String id;
    private String initialpoint;
    private String endpoint;
    private String orderStatus;
    private Timestamp createTime;
    private Timestamp modifiedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInitialpoint() {
        return initialpoint;
    }

    public void setInitialpoint(String initialpoint) {
        this.initialpoint = initialpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}