package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.OrdersDAO;
import lk.ijse.computershop.entity.Orders;

import java.sql.SQLException;
import java.util.List;

public class OrdersDAOImpl implements OrdersDAO {

    @Override
    public List<Orders> loadAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Orders entity) throws SQLException {
        return 0;
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
    public String generateNextId() throws SQLException {
        return null;
    }

    @Override
    public List<String> loadOrderIds() throws SQLException {
        return null;
    }
}
