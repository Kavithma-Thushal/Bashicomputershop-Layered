package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.OrderDetailsDAO;
import lk.ijse.computershop.dto.OrderDTO;
import lk.ijse.computershop.entity.Order_Details;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {

    @Override
    public List<Order_Details> loadAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Order_Details entity) throws SQLException {
        return 0;
    }

    @Override
    public Order_Details search(String id) throws SQLException {
        return null;
    }

    @Override
    public int update(Order_Details entity) throws SQLException {
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
    public boolean placeOrder(String orderId, List<OrderDTO> orderDTOList, LocalDate date) throws SQLException {
        return false;
    }
}
