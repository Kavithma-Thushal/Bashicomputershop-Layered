package lk.ijse.computershop.bo.custom;

import lk.ijse.computershop.bo.SuperBO;
import lk.ijse.computershop.dto.CustombuildsDTO;
import lk.ijse.computershop.dto.CustomerDTO;
import lk.ijse.computershop.dto.EmployeeDTO;
import lk.ijse.computershop.dto.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public interface CustombuildsBO extends SuperBO {
    /*Transaction*/
    boolean makeBuild(String buildCode, String customerId, String employeeId, List<CustombuildsDTO> buildList) throws SQLException;

    String getNextId() throws SQLException;

    List<String> loadCustomerIds() throws SQLException;

    List<String> loadEmployeeIds() throws SQLException;

    List<String> loadItemCodes() throws SQLException;

    CustomerDTO searchByCustomerId(String customerId) throws SQLException;

    EmployeeDTO searchByEmployeeId(String employeeId) throws SQLException;

    ItemDTO searchByItemCodes(String itemCode) throws SQLException;
}
