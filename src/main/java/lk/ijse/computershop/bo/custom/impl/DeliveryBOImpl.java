package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.DeliveryBO;
import lk.ijse.computershop.dao.DAOFactory;
import lk.ijse.computershop.dao.custom.CustomerDAO;
import lk.ijse.computershop.dao.custom.DeliveryDAO;
import lk.ijse.computershop.dao.custom.EmployeeDAO;
import lk.ijse.computershop.dao.custom.OrdersDAO;
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

    private DeliveryDAO deliveryDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.DELIVERY);
    private CustomerDAO customerDAO=DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private EmployeeDAO employeeDAO=DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    private OrdersDAO ordersDAO=DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDERS);

    @Override
    public List<DeliveryDTO> loadAllDelivers() throws SQLException {
        List<DeliveryDTO> deliveryDTOList=new ArrayList<>();
        List<Delivery> deliveryList=deliveryDAO.loadAll();
        for (Delivery d:deliveryList) {
            deliveryDTOList.add(new DeliveryDTO(d.getCode(),d.getCustomerId(),d.getEmployeeId(),d.getOrderId(),d.getLocation(),d.getDate()));
        }
        return deliveryDTOList;
    }

    @Override
    public int saveDelivers(DeliveryDTO d) throws SQLException {
        return deliveryDAO.save(new Delivery(d.getCode(),d.getCustomerId(),d.getEmployeeId(),d.getOrderId(),d.getLocation(),d.getDate()));
    }

    @Override
    public String generateNextDeliverCode() throws SQLException {
        return deliveryDAO.generateNextId();
    }

    @Override
    public List<String> loadCustomerIds() throws SQLException {
        return customerDAO.loadCustomerIds();
    }

    @Override
    public CustomerDTO searchByCustomerId(String id) throws SQLException {
        Customer c=customerDAO.search(id);
        return new CustomerDTO(c.getId(),c.getName(),c.getNic(),c.getEmail(),c.getContact(),c.getAddress());
    }

    @Override
    public List<String> loadEmployeeIds() throws SQLException {
        return employeeDAO.loadEmployeeIds();
    }

    @Override
    public EmployeeDTO searchByEmployeeId(String id) throws SQLException {
        Employee e=employeeDAO.search(id);
        return new EmployeeDTO(e.getId(),e.getName(),e.getContact(),e.getJobRole(),e.getUsername(),e.getPassword());
    }

    @Override
    public List<String> loadOrderIds() throws SQLException {
        return ordersDAO.loadOrderIds();
    }
}
