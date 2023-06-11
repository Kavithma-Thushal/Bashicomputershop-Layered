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
    public int save(CustomerDTO customerDTO) throws SQLException {
        return customerDAO.save(new Customer(
                        customerDTO.getId(),
                        customerDTO.getName(),
                        customerDTO.getNic(),
                        customerDTO.getEmail(),
                        customerDTO.getContact(),
                        customerDTO.getAddress()
                )
        );
    }

    @Override
    public CustomerDTO search(String id) throws SQLException {
        Customer customer = customerDAO.search(id);
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getNic(), customer.getEmail(), customer.getContact(), customer.getAddress());
    }

    @Override
    public int update(CustomerDTO customerDTO) throws SQLException {
        return customerDAO.update(new Customer(
                        customerDTO.getId(),
                        customerDTO.getName(),
                        customerDTO.getNic(),
                        customerDTO.getEmail(),
                        customerDTO.getContact(),
                        customerDTO.getAddress()
                )
        );
    }

    @Override
    public int delete(String id) throws SQLException {
        return customerDAO.delete(id);
    }

    @Override
    public List<CustomerDTO> getAll() throws SQLException {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        List<Customer> customers = customerDAO.getAll();
        for (Customer c : customers) {
            customerDTOList.add(new CustomerDTO(c.getId(), c.getName(), c.getNic(), c.getEmail(), c.getContact(), c.getAddress()));
        }
        return customerDTOList;
    }

    @Override
    public String getNextId() throws SQLException {
        return customerDAO.getNextId();
    }

    @Override
    public List<String> loadIds() throws SQLException {
        return customerDAO.loadIds();
    }

    @Override
    public CustomerDTO searchById(String customerId) throws SQLException {
        Customer customer = customerDAO.searchById(customerId);
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getNic(), customer.getEmail(), customer.getContact(), customer.getAddress());
    }
}
