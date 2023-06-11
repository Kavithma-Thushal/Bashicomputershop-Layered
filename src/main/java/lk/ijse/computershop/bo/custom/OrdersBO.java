package lk.ijse.computershop.bo.custom;

import lk.ijse.computershop.bo.SuperBO;
import lk.ijse.computershop.dto.CustomerDTO;
import lk.ijse.computershop.dto.ItemDTO;
import lk.ijse.computershop.dto.OrderDTO;

import java.sql.SQLException;
import java.util.List;

public interface OrdersBO extends SuperBO {

    List<String> loadIds() throws SQLException;

    String getNextId() throws SQLException;

    boolean placeOrder(String orderId, String customerId, List<OrderDTO> orderDTOList) throws SQLException;

    List<String> loadCustomerIds() throws SQLException;

    CustomerDTO searchByCustomrtId(String customerId) throws SQLException;

    List<String> loadItemCodes() throws SQLException;

    ItemDTO searchByOrderId(String itemCode) throws SQLException;
}
