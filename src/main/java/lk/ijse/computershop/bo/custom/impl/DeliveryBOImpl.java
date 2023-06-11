package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.DeliveryBO;
import lk.ijse.computershop.dao.DAOFactory;
import lk.ijse.computershop.dao.custom.CustomerDAO;
import lk.ijse.computershop.dao.custom.DeliveryDAO;
import lk.ijse.computershop.dao.custom.EmployeeDAO;
import lk.ijse.computershop.dao.custom.impl.OrdersDAOImpl;
import lk.ijse.computershop.dto.CustomerDTO;
import lk.ijse.computershop.dto.DeliveryDTO;
import lk.ijse.computershop.dto.EmployeeDTO;
import lk.ijse.computershop.entity.Customer;
import lk.ijse.computershop.entity.Delivery;
import lk.ijse.computershop.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryBOImpl implements DeliveryBO {

    private CustomerDAO customerDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private EmployeeDAO employeeDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    private OrdersDAOImpl ordersDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDERS);
    private DeliveryDAO deliveryDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.DELIVERY);

    @Override
    public List<DeliveryDTO> getAll() throws SQLException {
        List<DeliveryDTO> deliveryList = new ArrayList<>();
        List<Delivery> list = deliveryDAO.getAll();
        for (Delivery d : list) {
            deliveryList.add(new DeliveryDTO(d.getCode(),d.getCustomerId(),d.getEmployeeId(),d.getOrderId(),d.getLocation(),d.getDate()));
        }
        return deliveryList;
    }

    @Override
    public String getNextId() throws SQLException {
        return deliveryDAO.getNextId();
    }

    @Override
    public List<String> loadCustomerIds() throws SQLException {
        return customerDAO.loadIds();
    }

    @Override
    public CustomerDTO searchByCustomerId(String customerId) throws SQLException {
        Customer customer = customerDAO.searchById(customerId);
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getNic(), customer.getEmail(), customer.getContact(), customer.getAddress());
    }

    @Override
    public List<String> loadEmployeeIds() throws SQLException {
        return employeeDAO.loadEmployeeIds();
    }

    @Override
    public EmployeeDTO searchByEmployeeId(String employeeId) throws SQLException {
        Employee e=employeeDAO.searchById(employeeId);
        return new EmployeeDTO(e.getId(),e.getName(),e.getContact(),e.getJobRole(),e.getUsername(),e.getPassword());
    }

    @Override
    public List<String> loadOrderIds() throws SQLException {
        return ordersDAO.loadIds();
    }
}
