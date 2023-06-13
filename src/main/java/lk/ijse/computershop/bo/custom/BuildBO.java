package lk.ijse.computershop.bo.custom;

import lk.ijse.computershop.bo.SuperBO;
import lk.ijse.computershop.dto.BuildDTO;
import lk.ijse.computershop.dto.CustomerDTO;
import lk.ijse.computershop.dto.EmployeeDTO;
import lk.ijse.computershop.dto.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public interface BuildBO extends SuperBO {

    String generateNextBuildCode() throws SQLException;

    List<String> loadCustomerIds() throws SQLException;

    CustomerDTO searchByCustomerId(String customerId) throws SQLException;

    List<String> loadEmployeeIds() throws SQLException;

    EmployeeDTO searchByEmployeeId(String employeeId) throws SQLException;

    List<String> loadItemCodes() throws SQLException;

    ItemDTO searchByItemCodes(String itemCode) throws SQLException;

    boolean makeBuild(BuildDTO buildDTO) throws  SQLException;
}
