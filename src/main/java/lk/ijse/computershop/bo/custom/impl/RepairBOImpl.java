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

    private RepairDAO repairDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.REPAIR);
    private CustomerDAO customerDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private EmployeeDAO employeeDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public List<RepairDTO> loadAllRepairs() throws SQLException {
        List<RepairDTO> repairDTOList = new ArrayList<>();
        List<Repairs> repairsList = repairDAO.loadAll();
        for (Repairs r : repairsList) {
            repairDTOList.add(new RepairDTO(r.getCode(), r.getCustomerId(), r.getEmployeeId(), r.getDetails(), r.getGetDate(), r.getAcceptDate()));
        }
        return repairDTOList;
    }

    @Override
    public int saveRepairs(RepairDTO dto) throws SQLException {
        return repairDAO.save(new Repairs(dto.getCode(),dto.getCustomerId(), dto.getEmployeeId(),dto.getDetails(),dto.getGettingDate(),dto.getAcceptingDate()));
    }

    @Override
    public RepairDTO searchRepair(String code) throws SQLException {
        Repairs r = repairDAO.search(code);
        return new RepairDTO(r.getCode(), r.getCustomerId(), r.getEmployeeId(), r.getDetails(), r.getGetDate(), r.getAcceptDate());
    }

    @Override
    public String generateNextRepairCode() throws SQLException {
        return repairDAO.generateNextId();
    }

    @Override
    public List<String> loadCustomerIds() throws SQLException {
        return customerDAO.loadCustomerIds();
    }

    @Override
    public CustomerDTO searchByCustomerId(String id) throws SQLException {
        Customer c = customerDAO.search(id);
        return new CustomerDTO(c.getId(), c.getName(), c.getNic(), c.getEmail(), c.getContact(), c.getAddress());
    }

    @Override
    public List<String> loadEmployeeIds() throws SQLException {
        return employeeDAO.loadEmployeeIdsToRepair();
    }

    @Override
    public EmployeeDTO searchByEmployeeId(String id) throws SQLException {
        Employee e = employeeDAO.search(id);
        return new EmployeeDTO(e.getId(), e.getName(), e.getContact(), e.getJobRole(), e.getUsername(), e.getPassword());
    }
}
