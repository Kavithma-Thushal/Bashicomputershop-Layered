package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.ItemBO;
import lk.ijse.computershop.dto.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public class ItemBOImpl implements ItemBO {

    @Override
    public List<ItemDTO> loadAllItems() throws SQLException {
        return null;
    }

    @Override
    public int saveItem(ItemDTO itemDTO) throws SQLException {
        return 0;
    }

    @Override
    public ItemDTO searchItem(String itemCode) throws SQLException {
        return null;
    }

    @Override
    public int updateItem(ItemDTO itemDTO) throws SQLException {
        return 0;
    }

    @Override
    public int deleteItem(String itemCode) throws SQLException {
        return 0;
    }

    @Override
    public String generateNextItemCode() throws SQLException {
        return null;
    }

    @Override
    public List<String> loadItemCodes() throws SQLException {
        return null;
    }

    @Override
    public ItemDTO searchByItemCode(String itemCode) throws SQLException {
        return null;
    }
}
