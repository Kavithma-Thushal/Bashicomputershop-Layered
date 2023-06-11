package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.OrdersBO;
import lk.ijse.computershop.dto.CustomerDTO;
import lk.ijse.computershop.dto.ItemDTO;
import lk.ijse.computershop.dto.OrderDTO;

import java.sql.SQLException;
import java.util.List;

public class OrdersBOImpl implements OrdersBO {

    @Override
    public List<String> loadOrderIds() throws SQLException {
        return null;
    }

    @Override
    public List<String> loadCustomerIds() throws SQLException {
        return null;
    }

    @Override
    public List<String> loadItemCodes() throws SQLException {
        return null;
    }

    @Override
    public String generateNextOrderId() throws SQLException {
        return null;
    }

    @Override
    public ItemDTO searchByOrderId(String itemCode) throws SQLException {
        return null;
    }

    @Override
    public CustomerDTO searchByCustomerId(String customerId) throws SQLException {
        return null;
    }

    @Override
    public boolean placeOrder(String orderId, String customerId, List<OrderDTO> orderDTOList) throws SQLException {
        return false;
    }
}
