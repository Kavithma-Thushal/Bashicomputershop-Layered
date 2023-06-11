package lk.ijse.computershop.bo.custom;

import lk.ijse.computershop.bo.SuperBO;
import lk.ijse.computershop.dto.CustomerDTO;
import lk.ijse.computershop.dto.EmployeeDTO;
import lk.ijse.computershop.dto.RepairDTO;

import java.sql.SQLException;
import java.util.List;

public interface RepairBO extends SuperBO {

    List<RepairDTO> getAll() throws SQLException;

    RepairDTO search(String code) throws SQLException;

    String getNextId() throws SQLException;

    List<String> loadCustomerIds() throws SQLException;

    CustomerDTO searchByCustomertId(String customerId) throws SQLException;

    List<String> loadEmployeeIds() throws SQLException;

    EmployeeDTO searchByEmployeeId(String employeeId) throws SQLException;
}
