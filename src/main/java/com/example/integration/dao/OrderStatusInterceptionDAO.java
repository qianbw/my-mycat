package com.example.integration.dao;

import com.example.common.dto.OrderStatusInterceptionDTO;

import java.sql.SQLException;
import java.util.List;


public interface OrderStatusInterceptionDAO {

    public int add(OrderStatusInterceptionDTO orderStatusInterceptionDTO) throws SQLException;

    public List<OrderStatusInterceptionDTO> getList(String id) throws SQLException;
}
