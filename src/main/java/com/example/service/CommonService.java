package com.example.service;

import com.example.common.dto.CourierDTO;
import com.example.common.dto.OrdersDTO;

public interface CommonService {

    public int addCourier(CourierDTO courierDTO);

    public int addOrders(OrdersDTO ordersDTO);

}
