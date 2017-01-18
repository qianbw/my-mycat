package com.example.integration.dao.impl;

import com.example.common.dao.AbstractSimpleDAO;
import com.example.common.dao.BaseSqlSession;
import com.example.common.dto.CustomerDTO;
import com.example.integration.dao.CustomerDAO;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("com.example.integration.dao.impl.CustomerDAO")
public class CustomerDAOImpl extends AbstractSimpleDAO implements CustomerDAO {
    @Override
    public int add(CustomerDTO customerDTO) throws SQLException {
        try (BaseSqlSession session = getSession()) {
            return session.getMapper(CustomerDAO.class).add(customerDTO);
        }
    }

    @Override
    public List<CustomerDTO> getList(String id) throws SQLException {
        try (BaseSqlSession session = getSession()) {
            return session.getMapper(CustomerDAO.class).getList(id);
        }
    }
}
