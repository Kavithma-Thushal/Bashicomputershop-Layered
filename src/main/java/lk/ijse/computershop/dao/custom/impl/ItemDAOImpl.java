package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.ItemDAO;
import lk.ijse.computershop.dao.custom.impl.util.SQLUtil;
import lk.ijse.computershop.dto.CustombuildsDTO;
import lk.ijse.computershop.dto.ItemDTO;
import lk.ijse.computershop.dto.OrderDTO;
import lk.ijse.computershop.entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public int save(Item entity) throws SQLException {
        String sql = "INSERT INTO item VALUES (?,?,?,?)";
        return SQLUtil.execute(
                sql,
                entity.getCode(),
                entity.getDescription(),
                entity.getUnitPrice(),
                entity.getQtyOnHand()
        );
    }

    @Override
    public Item search(String code) throws SQLException {
        String sql = "SELECT * FROM item WHERE code=?";

        ResultSet resultSet = SQLUtil.execute(sql, code);
        if (resultSet.next()) {
            return new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            );
        }
        return null;
    }

    @Override
    public int update(Item entity) throws SQLException {
        String sql = "UPDATE item SET description=? , unitPrice=? , qtyOnHand=? WHERE code=?";

        return SQLUtil.execute(
                sql,
                entity.getDescription(),
                entity.getUnitPrice(),
                entity.getQtyOnHand(),
                entity.getCode()
        );
    }

    @Override
    public int delete(String code) throws SQLException {
        String sql = "DELETE FROM item WHERE code=?";
        return SQLUtil.execute(sql, code);
    }

    @Override
    public List<Item> getAll() throws SQLException {

        List<Item> itemList = new ArrayList<>();
        String sql = "SELECT * FROM item";
        ResultSet resultSet = SQLUtil.execute(sql);

        while (resultSet.next()) {
            Item item = new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            );
            itemList.add(item);
        }
        return itemList;
    }

    @Override
    public String getNextId() throws SQLException {
        String sql = "SELECT code FROM item ORDER BY code DESC LIMIT 1";

        ResultSet resultSet = SQLUtil.execute(sql);
        if (resultSet.next()) {
            return splitItemCode(resultSet.getString(1));
        }
        return splitItemCode(null);
    }

    private String splitItemCode(String currentId) {
        if (currentId != null) {
            String[] strings = currentId.split("P");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "P" + String.format("%02d", id);
        }
        return "P01";
    }

    @Override
    public List<String> loadCodes() throws SQLException {
        String sql = "SELECT code FROM item  ORDER BY code ASC";
        ResultSet resultSet = SQLUtil.execute(sql);

        List<String> data = new ArrayList<>();
        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }

    @Override
    public ItemDTO searchById(String itemCode) throws SQLException {
        String sql = "SELECT * FROM item WHERE code = ?";
        ResultSet resultSet = SQLUtil.execute(sql, itemCode);

        if (resultSet.next()) {
            return new ItemDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            );
        }
        return null;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////    Orders
    @Override
    public boolean updateQty(List<OrderDTO> orderDTOList) throws SQLException {
        for (OrderDTO orderDTODetails : orderDTOList) {
            if (!updateQty(orderDTODetails)) {
                return false;
            }
        }
        return true;
    }

    private boolean updateQty(OrderDTO orderDTODetails) throws SQLException {
        String sql = "UPDATE item SET qtyOnHand = (qtyOnHand - ?) WHERE code = ?";
        Integer affectedRows = SQLUtil.execute(sql, orderDTODetails.getQty(), orderDTODetails.getCode());
        return affectedRows > 0;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////    Custom Build
    @Override
    public boolean updateBuildQty(List<CustombuildsDTO> buildsList) throws SQLException {
        for (CustombuildsDTO custombuildsDTO : buildsList) {
            if (!updateBuildQty(custombuildsDTO)) {
                return false;
            }
        }
        return true;
    }

    private boolean updateBuildQty(CustombuildsDTO buildsList) throws SQLException {
        String sql = "UPDATE item SET qtyOnHand = (qtyOnHand - ?) WHERE code = ?";
        Integer affectedRows = SQLUtil.execute(sql, buildsList.getQty(), buildsList.getCode());
        return affectedRows > 0;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////    Suppliers
    @Override
    public boolean updateSupplyQty(String itemCode,String supplyQty) throws SQLException {
        String sql = "UPDATE item SET qtyOnHand = (qtyOnHand + ?) WHERE code = ?";
        Integer affectedRows = SQLUtil.execute(sql, supplyQty, itemCode);
        return affectedRows > 0;
    }
}
