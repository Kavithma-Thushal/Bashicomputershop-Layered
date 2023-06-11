package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.SalaryBO;
import lk.ijse.computershop.dto.EmployeeDTO;
import lk.ijse.computershop.dto.SalaryDTO;

import java.sql.SQLException;
import java.util.List;

public class SalaryBOImpl implements SalaryBO {

    @Override
    public List<SalaryDTO> loadAllSalary() throws SQLException {
        return null;
    }

    @Override
    public String generateNextSalaryCode() throws SQLException {
        return null;
    }

    @Override
    public List<String> loadEmployeeIds() throws SQLException {
        return null;
    }

    @Override
    public EmployeeDTO searchByEmployeeId(String employeeId) throws SQLException {
        return null;
    }
}
