package com.example.integration.dao;

import com.example.common.dto.OrdersDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface OrdersDAO {

    public int add(OrdersDTO ordersDTO) throws SQLException;

    public List<OrdersDTO> getList(String id) throws SQLException;
}
