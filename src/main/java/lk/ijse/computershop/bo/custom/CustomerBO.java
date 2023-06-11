package lk.ijse.computershop.bo.custom;

import lk.ijse.computershop.bo.SuperBO;
import lk.ijse.computershop.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SuperBO {

    int save(CustomerDTO customerDTO) throws SQLException;

    CustomerDTO search(String id) throws SQLException;

    int update(CustomerDTO customerDTO) throws SQLException;

    int delete(String id) throws SQLException;

    List<CustomerDTO> getAll() throws SQLException;

    String getNextId() throws SQLException;

    List<String> loadIds() throws SQLException;

    CustomerDTO searchById(String customerId) throws SQLException;
}
