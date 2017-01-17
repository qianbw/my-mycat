package com.example.integration.dao;

import com.example.common.dto.OrderCargoDTO;

import java.sql.SQLException;
import java.util.List;


public interface OrderCargoDAO {

    public int add(OrderCargoDTO orderCargoDTO) throws SQLException;

    public List<OrderCargoDTO> getList(String id) throws SQLException;
}
