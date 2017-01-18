package com.example.service;

import com.example.common.dto.CourierDTO;
import com.example.common.dto.OrderCargoDTO;
import com.example.common.dto.OrderStatusInterceptionDTO;
import com.example.common.dto.OrdersDTO;

public interface CommonService {

    public int addCourier(CourierDTO courierDTO);

    public int addOrders(OrdersDTO ordersDTO);

    public int addOrderCargo(OrderCargoDTO orderCargoDTO);

    public int addOrderStatusInterception(OrderStatusInterceptionDTO orderStatusInterceptionDTO);

    /**
     * 单库同时修改2张表
     * @throws Exception
     */
    public void addOrderAndCargoInSingleDB() throws Exception;

    /**
     * 跨库同时修改2张表
     * @throws Exception
     */
    public void addOrderAndCargoInMultiDB() throws Exception;

}
