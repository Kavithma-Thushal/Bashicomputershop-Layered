package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.CustomerDAO;
import lk.ijse.computershop.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public List<Customer> loadAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Customer entity) throws SQLException {
        return 0;
    }

    @Override
    public Customer search(String id) throws SQLException {
        return null;
    }

    @Override
    public int update(Customer entity) throws SQLException {
        return 0;
    }

    @Override
    public int delete(String id) throws SQLException {
        return 0;
    }

    @Override
    public String generateNextId() throws SQLException {
        return null;
    }

    @Override
    public List<String> loadCustomerIds() throws SQLException {
        return null;
    }

    @Override
    public Customer searchByCustomerId(String customerId) throws SQLException {
        return null;
    }
}
