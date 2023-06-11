package lk.ijse.computershop.dao.custom;

import lk.ijse.computershop.dao.CrudDAO;
import lk.ijse.computershop.dto.OrderDTO;
import lk.ijse.computershop.entity.Order_Details;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface OrderDetailsDAO extends CrudDAO<Order_Details> {
    boolean save(String orderId, List<OrderDTO> orderDTOList, LocalDate date) throws SQLException;
}
