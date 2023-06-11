package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.OrderDetailsDAO;
import lk.ijse.computershop.dao.custom.impl.util.SQLUtil;
import lk.ijse.computershop.dto.OrderDTO;
import lk.ijse.computershop.entity.Order_Details;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {

    @Override
    public boolean placeOrder(String orderId, List<OrderDTO> orderDTOList, LocalDate date) throws SQLException {
        for (OrderDTO orderDTODetails : orderDTOList) {
            if (!save(orderId, orderDTODetails, LocalDate.now())) {
                return false;
            }
        }
        return true;
    }

    private boolean save(String orderId, OrderDTO orderDTODetails, LocalDate date) throws SQLException {
        String sql = "INSERT INTO order_details VALUES(?, ?, ?, ?,?)";
        Integer affectedRows = SQLUtil.execute(sql, orderId, orderDTODetails.getCode(), orderDTODetails.getQty(), orderDTODetails.getTotal(), Date.valueOf(date));
        return affectedRows > 0;
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
    public List<Order_Details> loadAll() throws SQLException {
        return null;
    }

    @Override
    public String generateNextId() throws SQLException {
        return null;
    }
}
