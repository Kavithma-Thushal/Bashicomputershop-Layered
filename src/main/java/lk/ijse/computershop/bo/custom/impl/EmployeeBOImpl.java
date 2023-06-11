package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.EmployeeBO;
import lk.ijse.computershop.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    @Override
    public List<EmployeeDTO> loadAllEmployees() throws SQLException {
        return null;
    }

    @Override
    public int saveEmployee(EmployeeDTO employeeDTO) throws SQLException {
        return 0;
    }

    @Override
    public EmployeeDTO searchEmployee(String id) throws SQLException {
        return null;
    }

    @Override
    public int updateEmployee(EmployeeDTO employeeDTO) throws SQLException {
        return 0;
    }

    @Override
    public int deletEmployeee(String id) throws SQLException {
        return 0;
    }

    @Override
    public String generateNextEmployeeId() throws SQLException {
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
