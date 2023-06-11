package lk.ijse.computershop.model;

import lk.ijse.computershop.dto.OrderDTO;
import lk.ijse.computershop.util.CrudUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class OrderDetailModel {

    public static boolean save(String orderId, List<OrderDTO> orderDTOList, LocalDate date) throws SQLException {
        for (OrderDTO orderDTODetails : orderDTOList) {
            if (!save(orderId, orderDTODetails, LocalDate.now())) {
                return false;
            }
        }
        return true;
    }

    private static boolean save(String orderId, OrderDTO orderDTODetails, LocalDate date) throws SQLException {
        String sql = "INSERT INTO order_details VALUES(?, ?, ?, ?,?)";
        Integer affectedRows = CrudUtil.execute(sql, orderId, orderDTODetails.getCode(), orderDTODetails.getQty(), orderDTODetails.getTotal(), Date.valueOf(date));
        return affectedRows > 0;
    }
}
