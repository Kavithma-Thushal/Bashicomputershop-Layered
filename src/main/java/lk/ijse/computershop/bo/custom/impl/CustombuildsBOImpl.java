package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.CustombuildsBO;
import lk.ijse.computershop.dto.CustombuildsDTO;
import lk.ijse.computershop.dto.CustomerDTO;
import lk.ijse.computershop.dto.EmployeeDTO;
import lk.ijse.computershop.dto.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public class CustombuildsBOImpl implements CustombuildsBO {

    @Override
    public String generateNextBuildCode() throws SQLException {
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
    public List<String> loadItemCodes() throws SQLException {
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

    @Override
    public ItemDTO searchByItemCodes(String itemCode) throws SQLException {
        return null;
    }

    @Override
    public boolean buildQuotation(String buildCode, String customerId, String employeeId, List<CustombuildsDTO> buildDTOList) throws SQLException {
        return false;
    }
}
