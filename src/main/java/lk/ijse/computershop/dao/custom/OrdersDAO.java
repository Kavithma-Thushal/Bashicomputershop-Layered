package lk.ijse.computershop.dao.custom;

import lk.ijse.computershop.dao.CrudDAO;
import lk.ijse.computershop.entity.Orders;

import java.sql.SQLException;
import java.util.List;

public interface OrdersDAO extends CrudDAO<Orders> {
    List<String> loadOrderIds() throws SQLException;
}
