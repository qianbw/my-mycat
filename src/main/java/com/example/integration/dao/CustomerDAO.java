package com.example.integration.dao;

import com.example.common.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.List;


public interface CustomerDAO {

    public int add(CustomerDTO customerDTO) throws SQLException;

    public List<CustomerDTO> getList(String id) throws SQLException;
}
