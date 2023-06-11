package lk.ijse.computershop.model;

import lk.ijse.computershop.dto.CustomerDTO;
import lk.ijse.computershop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {

    public static int save(CustomerDTO customerDTO) throws SQLException {
        String sql = "INSERT INTO customer VALUES (?,?,?,?,?,?)";

        return CrudUtil.execute(
                sql,
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getNic(),
                customerDTO.getEmail(),
                customerDTO.getContact(),
                customerDTO.getAddress()
        );
    }

    public static CustomerDTO search(String id) throws SQLException {
        String sql = "SELECT * FROM customer WHERE id=?";

        ResultSet resultSet = CrudUtil.execute(sql, id);
        if (resultSet.next()) {
            return new CustomerDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
        }
        return null;
    }

    public static int update(CustomerDTO customerDTO) throws SQLException {
        String sql = "UPDATE customer SET name=? , nic=? , email=? , contact=? , address=? WHERE id=?";

        return CrudUtil.execute(
                sql,
                customerDTO.getName(),
                customerDTO.getNic(),
                customerDTO.getEmail(),
                customerDTO.getContact(),
                customerDTO.getAddress(),
                customerDTO.getId()
        );
    }

    public static int delete(String id) throws SQLException {
        String sql = "DELETE FROM customer WHERE id=?";
        return CrudUtil.execute(sql, id);
    }

    public static List<CustomerDTO> getAll() throws SQLException {

        List<CustomerDTO> customerDTOList = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    public static String getNextCustomerId() throws SQLException {
        String sql = "SELECT id FROM customer ORDER BY id DESC LIMIT 1";
        ResultSet resultSet = CrudUtil.execute(sql);

        if (resultSet.next()) {
            return splitCustomerId(resultSet.getString(1));
        }
        return splitCustomerId(null);
    }

    private static String splitCustomerId(String currentId) {
        if (currentId != null) {
            String[] strings = currentId.split("C");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "C" + String.format("%02d", id);
        }
        return "C01";
    }

    public static List<String> loadIds() throws SQLException {
        String sql = "SELECT id FROM customer ORDER BY id ASC";
        ResultSet resultSet = CrudUtil.execute(sql);

        List<String> data = new ArrayList<>();
        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }

    public static CustomerDTO searchById(String customerId) throws SQLException {
        String sql = "SELECT * FROM Customer WHERE id = ?";
        ResultSet resultSet = CrudUtil.execute(sql, customerId);

        if (resultSet.next()) {
            return new CustomerDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
        }
        return null;
    }
}
