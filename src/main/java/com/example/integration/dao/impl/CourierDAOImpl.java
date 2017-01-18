package com.example.integration.dao.impl;

import com.example.common.dto.CourierDTO;
import com.example.common.dao.AbstractSimpleDAO;
import com.example.common.dao.BaseSqlSession;
import com.example.integration.dao.CourierDAO;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("com.example.integration.dao.impl.CourierDAO")
public class CourierDAOImpl extends AbstractSimpleDAO implements CourierDAO {
    @Override
    public int add(CourierDTO courierDTO) throws SQLException {
        try (BaseSqlSession session = getSession()) {
            return session.getMapper(CourierDAO.class).add(courierDTO);
        }
    }

    @Override
    public List<CourierDTO> getList(String id) throws SQLException {
        try (BaseSqlSession session = getSession()) {
            return session.getMapper(CourierDAO.class).getList(id);
        }
    }
}
