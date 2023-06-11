package lk.ijse.computershop.bo.custom;

import lk.ijse.computershop.bo.SuperBO;
import lk.ijse.computershop.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SuperBO {

    int save(EmployeeDTO employeeDTO) throws SQLException;

    EmployeeDTO search(String id) throws SQLException;

    int update(EmployeeDTO employeeDTO) throws SQLException;

    int delete(String id) throws SQLException;

    List<EmployeeDTO> getAll() throws SQLException;

    String getNextId() throws SQLException;

    List<String> loadEmployeeIds() throws SQLException;

    EmployeeDTO searchById(String employeeId) throws SQLException;
}
