package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.RepairBO;
import lk.ijse.computershop.dao.DAOFactory;
import lk.ijse.computershop.dao.custom.CustomerDAO;
import lk.ijse.computershop.dao.custom.EmployeeDAO;
import lk.ijse.computershop.dao.custom.RepairDAO;
import lk.ijse.computershop.dto.CustomerDTO;
import lk.ijse.computershop.dto.EmployeeDTO;
import lk.ijse.computershop.dto.RepairDTO;
import lk.ijse.computershop.entity.Customer;
import lk.ijse.computershop.entity.Employee;
import lk.ijse.computershop.entity.Repairs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepairBOImpl implements RepairBO {

    private CustomerDAO customerDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private EmployeeDAO employeeDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    private RepairDAO repairDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.REPAIR);

    @Override
    public List<RepairDTO> getAll() throws SQLException {
        List<RepairDTO> repairDTOS = new ArrayList<>();
        List<Repairs> repairs = repairDAO.getAll();
        for (Repairs r : repairs) {
            repairDTOS.add(new RepairDTO(r.getCode(),r.getCustomerId(),r.getEmployeeId(),r.getDetails(),r.getGetDate(),r.getAcceptDate()));
        }
        return repairDTOS;
    }

    @Override
    public RepairDTO search(String code) throws SQLException {
        Repairs repairs=repairDAO.search(code);
        return new RepairDTO(repairs.getCode(),repairs.getCustomerId(),repairs.getEmployeeId(),repairs.getDetails(),repairs.getGetDate(),repairs.getAcceptDate());
    }

    @Override
    public String getNextId() throws SQLException {
        return repairDAO.getNextId();
    }

    @Override
    public List<String> loadCustomerIds() throws SQLException {
        return customerDAO.loadIds();
    }

    @Override
    public CustomerDTO searchByCustomertId(String customerId) throws SQLException {
        Customer customer = customerDAO.searchById(customerId);
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getNic(), customer.getEmail(), customer.getContact(), customer.getAddress());
    }

    @Override
    public List<String> loadEmployeeIds() throws SQLException {
        return employeeDAO.loadIds();
    }

    @Override
    public EmployeeDTO searchByEmployeeId(String employeeId) throws SQLException {
        Employee e=employeeDAO.searchById(employeeId);
        return new EmployeeDTO(e.getId(),e.getName(),e.getContact(),e.getJobRole(),e.getUsername(),e.getPassword());
    }
}