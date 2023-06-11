package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.CustomerDAO;
import lk.ijse.computershop.dao.custom.impl.util.SQLUtil;
import lk.ijse.computershop.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public int save(Customer entity) throws SQLException {
        String sql = "INSERT INTO customer VALUES (?,?,?,?,?,?)";

        return SQLUtil.execute(
                sql,
                entity.getId(),
                entity.getName(),
                entity.getNic(),
                entity.getEmail(),
                entity.getContact(),
                entity.getAddress()
        );
    }

    @Override
    public Customer search(String id) throws SQLException {
        String sql = "SELECT * FROM customer WHERE id=?";

        ResultSet resultSet = SQLUtil.execute(sql, id);
        if (resultSet.next()) {
            return new Customer(
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

    @Override
    public int update(Customer entity) throws SQLException {
        String sql = "UPDATE customer SET name=? , nic=? , email=? , contact=? , address=? WHERE id=?";

        return SQLUtil.execute(
                sql,
                entity.getName(),
                entity.getNic(),
                entity.getEmail(),
                entity.getContact(),
                entity.getAddress(),
                entity.getId()
        );
    }

    @Override
    public int delete(String id) throws SQLException {
        String sql = "DELETE FROM customer WHERE id=?";
        return SQLUtil.execute(sql, id);
    }

    @Override
    public List<Customer> loadAll() throws SQLException {

        List<Customer> customerList = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        ResultSet resultSet = SQLUtil.execute(sql);

        while (resultSet.next()) {
            Customer customer = new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public String generateNextId() throws SQLException {
        String sql = "SELECT id FROM customer ORDER BY id DESC LIMIT 1";
        ResultSet resultSet = SQLUtil.execute(sql);

        if (resultSet.next()) {
            return splitCustomerId(resultSet.getString(1));
        }
        return splitCustomerId(null);
    }

    private String splitCustomerId(String currentId) {
        if (currentId != null) {
            String[] strings = currentId.split("C");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "C" + String.format("%02d", id);
        }
        return "C01";
    }

    @Override
    public List<String> loadCustomerIds() throws SQLException {
        String sql = "SELECT id FROM customer ORDER BY id ASC";
        ResultSet resultSet = SQLUtil.execute(sql);

        List<String> data = new ArrayList<>();
        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }

    @Override
    public Customer searchByCustomerId(String customerId) throws SQLException {
        String sql = "SELECT * FROM Customer WHERE id = ?";
        ResultSet resultSet = SQLUtil.execute(sql, customerId);

        if (resultSet.next()) {
            return new Customer(
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
