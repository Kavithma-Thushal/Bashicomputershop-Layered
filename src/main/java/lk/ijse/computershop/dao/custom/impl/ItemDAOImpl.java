package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.ItemDAO;
import lk.ijse.computershop.dto.CustombuildsDTO;
import lk.ijse.computershop.dto.ItemDTO;
import lk.ijse.computershop.dto.OrderDTO;
import lk.ijse.computershop.entity.Item;

import java.sql.SQLException;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public List<Item> loadAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Item entity) throws SQLException {
        return 0;
    }

    @Override
    public Item search(String id) throws SQLException {
        return null;
    }

    @Override
    public int update(Item entity) throws SQLException {
        return 0;
    }

    @Override
    public int delete(String id) throws SQLException {
        return 0;
    }

    @Override
    public String generateNextId() throws SQLException {
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

    @Override
    public boolean updateOrderQty(List<OrderDTO> orderDTOList) throws SQLException {
        return false;
    }

    @Override
    public boolean updateCustombuildQty(List<CustombuildsDTO> buildsList) throws SQLException {
        return false;
    }

    @Override
    public boolean updateSupplyQty(String itemCode, String supplyQty) throws SQLException {
        return false;
    }
}
