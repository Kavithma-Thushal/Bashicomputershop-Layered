package lk.ijse.computershop.dao.custom;

import lk.ijse.computershop.dao.CrudDAO;
import lk.ijse.computershop.dto.CustombuildsDTO;
import lk.ijse.computershop.dto.ItemDTO;
import lk.ijse.computershop.dto.OrderDTO;
import lk.ijse.computershop.entity.Item;
import lk.ijse.computershop.entity.Supplier_Details;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO extends CrudDAO<Item> {

    /*List<String> loadItemCodes() throws SQLException;

    Item searchByItemCode(String itemCode) throws SQLException;

    boolean updateOrderQty(List<OrderDTO> orderDTOList) throws SQLException;

    boolean updateCustombuildQty(List<CustombuildsDTO> buildsList) throws SQLException;

    boolean updateSupplyQty(Supplier_Details s) throws SQLException;*/
}
