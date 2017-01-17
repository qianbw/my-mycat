/**
 * Copyright (C) 2014 Webank Group Holding Limited
 */
package com.example.integration.dao.impl;

import com.example.common.dto.OrdersDTO;
import com.example.common.util.AbstractSimpleDAO;
import com.example.common.util.BaseSqlSession;
import com.example.integration.dao.OrdersDAO;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("com.example.integration.dao.impl.OrdersDAO")
public class OrdersDAOImpl extends AbstractSimpleDAO implements OrdersDAO {
    @Override
    public int add(OrdersDTO ordersDTO) throws SQLException {
        try (BaseSqlSession session = getSession()) {
            return session.getMapper(OrdersDAO.class).add(ordersDTO);
        }
    }

    @Override
    public List<OrdersDTO> getList(String id) throws SQLException {
        try (BaseSqlSession session = getSession()) {
            return session.getMapper(OrdersDAO.class).getList(id);
        }
    }
}
