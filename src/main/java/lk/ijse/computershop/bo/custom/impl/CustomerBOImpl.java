package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.CustomerBO;
import lk.ijse.computershop.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    @Override
    public List<CustomerDTO> loadAllCustomers() throws SQLException {
        return null;
    }

    @Override
    public int saveCustomer(CustomerDTO customerDTO) throws SQLException {
        return 0;
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException {
        return null;
    }

    @Override
    public int updateCustomer(CustomerDTO customerDTO) throws SQLException {
        return 0;
    }

    @Override
    public int deleteCustomer(String id) throws SQLException {
        return 0;
    }

    @Override
    public String generateNextCustomerId() throws SQLException {
        return null;
    }

    @Override
    public List<String> loadCustomerIds() throws SQLException {
        return null;
    }

    @Override
    public CustomerDTO searchByCustomerId(String customerId) throws SQLException {
        return null;
    }
}
