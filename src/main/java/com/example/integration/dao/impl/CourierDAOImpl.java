package com.example.integration.dao.impl;

import com.example.common.dto.CourierDTO;
import com.example.common.util.AbstractSimpleDAO;
import com.example.common.util.BaseSqlSession;
import com.example.integration.dao.CourierDAO;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository("com.example.integration.dao.impl.CourierDAO")
public class CourierDAOImpl extends AbstractSimpleDAO implements CourierDAO {
    @Override
    public int add(CourierDTO courierDTO) throws SQLException {
        try (BaseSqlSession session = getSession()) {
            return session.getMapper(CourierDAO.class).add(courierDTO);
        }
    }

    @Override
    public List<CourierDAO> getList(String id) throws SQLException {
        try (BaseSqlSession session = getSession()) {
            return session.getMapper(CourierDAO.class).getList(id);
        }
    }
}
