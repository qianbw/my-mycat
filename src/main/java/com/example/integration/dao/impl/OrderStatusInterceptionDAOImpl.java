package com.example.integration.dao.impl;

import com.example.common.dto.OrderStatusInterceptionDTO;
import com.example.common.dao.AbstractSimpleDAO;
import com.example.common.dao.BaseSqlSession;
import com.example.integration.dao.OrderStatusInterceptionDAO;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("com.example.integration.dao.impl.OrderStatusInterceptionDAO")
public class OrderStatusInterceptionDAOImpl extends AbstractSimpleDAO implements OrderStatusInterceptionDAO {

    @Override
    public int add(OrderStatusInterceptionDTO orderStatusInterceptionDTO) throws SQLException {
        try (BaseSqlSession session = getSession()) {
            return session.getMapper(OrderStatusInterceptionDAO.class).add(orderStatusInterceptionDTO);
        }
    }

    @Override
    public List<OrderStatusInterceptionDTO> getList(String orderStatus) throws SQLException {
        try (BaseSqlSession session = getSession()) {
            return session.getMapper(OrderStatusInterceptionDAO.class).getList(orderStatus);
        }
    }
}
