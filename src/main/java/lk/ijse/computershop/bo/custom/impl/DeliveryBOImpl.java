package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.DeliveryBO;
import lk.ijse.computershop.dto.CustomerDTO;
import lk.ijse.computershop.dto.DeliveryDTO;
import lk.ijse.computershop.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.List;

public class DeliveryBOImpl implements DeliveryBO {

    @Override
    public List<DeliveryDTO> loadAllDelivers() throws SQLException {
        return null;
    }

    @Override
    public String generateNextDeliverCode() throws SQLException {
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
    public List<String> loadOrderIds() throws SQLException {
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
