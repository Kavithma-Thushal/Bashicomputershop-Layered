package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.OrdersDAO;
import lk.ijse.computershop.dao.custom.impl.util.SQLUtil;
import lk.ijse.computershop.entity.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAOImpl implements OrdersDAO {

    @Override
    public int save(Orders entity) throws SQLException {
        String sql = "INSERT INTO Orders(orderId, customerId) VALUES(?, ?)";
        return SQLUtil.execute(sql, entity.getOrderId(), entity.getCustomerId());
    }

    @Override
    public List<String> loadIds() throws SQLException {
        String sql = "SELECT orderId FROM orders ORDER BY orderId ASC";
        ResultSet resultSet = SQLUtil.execute(sql);

        List<String> data = new ArrayList<>();
        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }

    @Override
    public String getNextId() throws SQLException {
        String sql = "SELECT orderId FROM Orders ORDER BY orderId DESC LIMIT 1";
        ResultSet resultSet = SQLUtil.execute(sql);

        if (resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }

    private String splitOrderId(String currentId) {
        if (currentId != null) {
            String[] strings = currentId.split("O");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "O" + String.format("%02d", id);
        }
        return "O01";
    }

    @Override
    public Orders search(String id) throws SQLException {
        return null;
    }

    @Override
    public int update(Orders entity) throws SQLException {
        return 0;
    }

    @Override
    public int delete(String id) throws SQLException {
        return 0;
    }

    @Override
    public List<Orders> getAll() throws SQLException {
        return null;
    }
}
