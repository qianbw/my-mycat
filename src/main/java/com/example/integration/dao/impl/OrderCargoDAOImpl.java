package com.example.integration.dao.impl;

import com.example.common.dto.OrderCargoDTO;
import com.example.common.util.AbstractSimpleDAO;
import com.example.common.util.BaseSqlSession;
import com.example.integration.dao.OrderCargoDAO;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("com.example.integration.dao.impl.OrderCargoDAO")
public class OrderCargoDAOImpl extends AbstractSimpleDAO implements OrderCargoDAO {
    @Override
    public int add(OrderCargoDTO orderCargoDTO) throws SQLException {
        try (BaseSqlSession session = getSession()) {
            return session.getMapper(OrderCargoDAO.class).add(orderCargoDTO);
        }
    }

    @Override
    public List<OrderCargoDTO> getList(String id) throws SQLException {
        try (BaseSqlSession session = getSession()) {
            return session.getMapper(OrderCargoDAO.class).getList(id);
        }
    }
}
