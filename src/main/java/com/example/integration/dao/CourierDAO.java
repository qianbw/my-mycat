package com.example.integration.dao;

import com.example.common.dto.CourierDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface CourierDAO {

    public int add(CourierDTO courierDTO) throws SQLException;

    public List<CourierDAO> getList(String id) throws SQLException;
}
