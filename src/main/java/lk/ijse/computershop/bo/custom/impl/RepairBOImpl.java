package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.RepairBO;
import lk.ijse.computershop.dto.CustomerDTO;
import lk.ijse.computershop.dto.EmployeeDTO;
import lk.ijse.computershop.dto.RepairDTO;

import java.sql.SQLException;
import java.util.List;

public class RepairBOImpl implements RepairBO {

    @Override
    public List<RepairDTO> loadAllRepairs() throws SQLException {
        return null;
    }

    @Override
    public RepairDTO searchRepair(String code) throws SQLException {
        return null;
    }

    @Override
    public String generateNextRepairCode() throws SQLException {
        return null;
    }

    @Override
    public List<String> loadCustomerIds() throws SQLException {
        return null;
    }

    @Override
    public List<String> loadEmployeeIds() throws SQLException {
        return null;
    }

    @Override
    public CustomerDTO searchByCustomerId(String customerId) throws SQLException {
        return null;
    }

    @Override
    public EmployeeDTO searchByEmployeeId(String employeeId) throws SQLException {
        return null;
    }
}
