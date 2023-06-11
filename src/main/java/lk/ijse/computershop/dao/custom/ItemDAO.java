package lk.ijse.computershop.dao.custom;

import lk.ijse.computershop.dao.CrudDAO;
import lk.ijse.computershop.dto.CustombuildsDTO;
import lk.ijse.computershop.dto.ItemDTO;
import lk.ijse.computershop.dto.OrderDTO;
import lk.ijse.computershop.entity.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO extends CrudDAO<Item> {

    List<String> loadCodes() throws SQLException;

    ItemDTO searchById(String itemCode) throws SQLException;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////    Orders
    boolean updateQty(List<OrderDTO> orderDTOList) throws SQLException;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////    Custom Build
    boolean updateBuildQty(List<CustombuildsDTO> buildsList) throws SQLException;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////    Suppliers
    boolean updateSupplyQty(String itemCode,String supplyQty) throws SQLException;
}
