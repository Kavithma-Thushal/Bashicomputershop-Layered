package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.CustomerBO;
import lk.ijse.computershop.dao.DAOFactory;
import lk.ijse.computershop.dao.custom.CustomerDAO;
import lk.ijse.computershop.dto.CustomerDTO;
import lk.ijse.computershop.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    private CustomerDAO customerDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public List<CustomerDTO> loadAllCustomers() throws SQLException {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        List<Customer> customerList = customerDAO.loadAll();
        for (Customer c : customerList) {
            customerDTOList.add(new CustomerDTO(c.getId(), c.getName(), c.getNic(), c.getEmail(), c.getContact(), c.getAddress()));
        }
        return customerDTOList;
    }

    @Override
    public int saveCustomer(CustomerDTO c) throws SQLException {
        return customerDAO.save(new Customer(c.getId(), c.getName(), c.getNic(), c.getEmail(), c.getContact(), c.getAddress()));
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException {
        Customer c = customerDAO.search(id);
        return new CustomerDTO(c.getId(), c.getName(), c.getNic(), c.getEmail(), c.getContact(), c.getAddress());
    }

    @Override
    public int updateCustomer(CustomerDTO c) throws SQLException {
        return customerDAO.update(new Customer(c.getId(), c.getName(), c.getNic(), c.getEmail(), c.getContact(), c.getAddress()));
    }

    @Override
    public int deleteCustomer(String id) throws SQLException {
        return customerDAO.delete(id);
    }

    @Override
    public String generateNextCustomerId() throws SQLException {
        return customerDAO.generateNextId();
    }

    @Override
    public List<String> loadCustomerIds() throws SQLException {
        return customerDAO.loadCustomerIds();
    }
}
