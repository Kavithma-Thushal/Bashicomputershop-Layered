package lk.ijse.computershop.bo.custom;

import lk.ijse.computershop.bo.SuperBO;
import lk.ijse.computershop.dto.CustomerDTO;
import lk.ijse.computershop.dto.DeliveryDTO;
import lk.ijse.computershop.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.List;

public interface DeliveryBO extends SuperBO {

    List<DeliveryDTO> loadAllDelivers() throws SQLException;

    int saveDelivers(DeliveryDTO d) throws SQLException;

    String generateNextDeliverCode() throws SQLException;

    List<String> loadCustomerIds() throws SQLException;

    CustomerDTO searchByCustomerId(String customerId) throws SQLException;

    List<String> loadEmployeeIds() throws SQLException;

    EmployeeDTO searchByEmployeeId(String employeeId) throws SQLException;

    List<String> loadOrderIds() throws SQLException;
}
