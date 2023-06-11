package lk.ijse.computershop.bo.custom;

import lk.ijse.computershop.bo.SuperBO;
import lk.ijse.computershop.dto.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public interface ItemBO extends SuperBO {

    List<ItemDTO> loadAllItems() throws SQLException;

    int saveItem(ItemDTO itemDTO) throws SQLException;

    ItemDTO searchItem(String itemCode) throws SQLException;

    int updateItem(ItemDTO itemDTO) throws SQLException;

    int deleteItem(String itemCode) throws SQLException;

    String generateNextItemCode() throws SQLException;

    List<String> loadItemCodes() throws SQLException;

    ItemDTO searchByItemCode(String itemCode) throws SQLException;
}
