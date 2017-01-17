/**
 * (C) 2014 Tencent Group Holding Limited.
 * <p>
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 2 as published by the Free Software Foundation.
 */
package com.example.service.impl;

import com.example.common.dto.CourierDTO;
import com.example.common.dto.OrderCargoDTO;
import com.example.common.dto.OrderStatusInterceptionDTO;
import com.example.common.dto.OrdersDTO;
import com.example.integration.dao.CourierDAO;
import com.example.integration.dao.OrderCargoDAO;
import com.example.integration.dao.OrderStatusInterceptionDAO;
import com.example.integration.dao.OrdersDAO;
import com.example.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service("com.example.service.CommonService")
public class CommonServiceImpl implements CommonService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Autowired
    @Qualifier("com.example.integration.dao.impl.CourierDAO")
    private CourierDAO courierDAO;

    @Autowired
    @Qualifier("com.example.integration.dao.impl.OrdersDAO")
    private OrdersDAO ordersDAO;

    @Autowired
    @Qualifier("com.example.integration.dao.impl.OrderCargoDAO")
    private OrderCargoDAO orderCargoDAO;

    @Autowired
    @Qualifier("com.example.integration.dao.impl.OrderStatusInterceptionDAO")
    private OrderStatusInterceptionDAO orderStatusInterceptionDAO;

    @Override
    public int addCourier(CourierDTO courierDTO) {
        int result = 0;
        try {
            result = courierDAO.add(courierDTO);
        } catch (SQLException e) {
            LOGGER.error("", e);
        }

        return result;
    }

    @Override
    public int addOrders(OrdersDTO ordersDTO) {
        int result = 0;
        try {
            result = ordersDAO.add(ordersDTO);
        } catch (SQLException e) {
            LOGGER.error("", e);
        }

        return result;
    }

    @Override
    public int addOrderCargo(OrderCargoDTO orderCargoDTO) {
        int result = 0;
        try {
            result = orderCargoDAO.add(orderCargoDTO);
        } catch (SQLException e) {
            LOGGER.error("", e);
        }

        return result;
    }

    @Override
    public int addOrderStatusInterception(OrderStatusInterceptionDTO orderStatusInterceptionDTO) {
        int result = 0;
        try {
            result = orderStatusInterceptionDAO.add(orderStatusInterceptionDTO);
        } catch (SQLException e) {
            LOGGER.error("", e);
        }

        return result;
    }
}
