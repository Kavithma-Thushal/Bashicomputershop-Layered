package lk.ijse.computershop.bo.custom;

import lk.ijse.computershop.bo.SuperBO;
import lk.ijse.computershop.dto.CustomerDTO;
import lk.ijse.computershop.dto.ItemDTO;
import lk.ijse.computershop.dto.OrderDTO;

import java.sql.SQLException;
import java.util.List;

public interface OrdersBO extends SuperBO {

    List<String> loadOrderIds() throws SQLException;

    List<String> loadCustomerIds() throws SQLException;

    List<String> loadItemCodes() throws SQLException;

    String generateNextOrderId() throws SQLException;

    ItemDTO searchByOrderId(String itemCode) throws SQLException;

    CustomerDTO searchByCustomerId(String customerId) throws SQLException;

    boolean placeOrder(String orderId, String customerId, List<OrderDTO> orderDTOList) throws SQLException;
}
