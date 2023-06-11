package lk.ijse.computershop.bo.custom;

import lk.ijse.computershop.bo.SuperBO;
import lk.ijse.computershop.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SuperBO {

    List<EmployeeDTO> loadAllEmployees() throws SQLException;

    int saveEmployee(EmployeeDTO employeeDTO) throws SQLException;

    EmployeeDTO searchEmployee(String id) throws SQLException;

    int updateEmployee(EmployeeDTO employeeDTO) throws SQLException;

    int deletEmployeee(String id) throws SQLException;

    String generateNextEmployeeId() throws SQLException;
}
