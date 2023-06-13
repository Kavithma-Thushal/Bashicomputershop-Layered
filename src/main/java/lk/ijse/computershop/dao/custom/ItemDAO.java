package lk.ijse.computershop.dao.custom;

import lk.ijse.computershop.dao.CrudDAO;
import lk.ijse.computershop.dto.CustombuildsDTO;
import lk.ijse.computershop.entity.Item;
import lk.ijse.computershop.entity.Order_Details;
import lk.ijse.computershop.entity.Supplier_Details;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO extends CrudDAO<Item> {

    List<String> loadItemCodes() throws SQLException;

    int updateOrderQty(Order_Details o) throws SQLException;

    int updateCustombuildQty(List<CustombuildsDTO> buildsList) throws SQLException;

    int updateSupplyQty(Supplier_Details s) throws SQLException;
}
