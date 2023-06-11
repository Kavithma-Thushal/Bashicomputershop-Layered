package lk.ijse.computershop.model;

import lk.ijse.computershop.dto.CustombuildsDTO;
import lk.ijse.computershop.dto.ItemDTO;
import lk.ijse.computershop.dto.OrderDTO;
import lk.ijse.computershop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemModel {

    public static int save(ItemDTO itemDTO) throws SQLException {
        String sql = "INSERT INTO item VALUES (?,?,?,?)";
        return CrudUtil.execute(
                sql,
                itemDTO.getCode(),
                itemDTO.getDescription(),
                itemDTO.getUnitPrice(),
                itemDTO.getQtyOnHand()
        );
    }

    public static ItemDTO search(String code) throws SQLException {
        String sql = "SELECT * FROM item WHERE code=?";

        ResultSet resultSet = CrudUtil.execute(sql, code);
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

    public static int update(ItemDTO itemDTO) throws SQLException {
        String sql = "UPDATE item SET description=? , unitPrice=? , qtyOnHand=? WHERE code=?";

        return CrudUtil.execute(
                sql,
                itemDTO.getDescription(),
                itemDTO.getUnitPrice(),
                itemDTO.getQtyOnHand(),
                itemDTO.getCode()
        );
    }

    public static int delete(String code) throws SQLException {
        String sql = "DELETE FROM item WHERE code=?";
        return CrudUtil.execute(sql, code);
    }

    public static List<ItemDTO> getAll() throws SQLException {

        List<ItemDTO> itemDTOList = new ArrayList<>();
        String sql = "SELECT * FROM item";
        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()) {
            ItemDTO itemDTO = new ItemDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            );
            itemDTOList.add(itemDTO);
        }
        return itemDTOList;
    }

    public static String getNextItemCode() throws SQLException {
        String sql = "SELECT code FROM item ORDER BY code DESC LIMIT 1";

        ResultSet resultSet = CrudUtil.execute(sql);
        if (resultSet.next()) {
            return splitItemCode(resultSet.getString(1));
        }
        return splitItemCode(null);
    }

    private static String splitItemCode(String currentId) {
        if (currentId != null) {
            String[] strings = currentId.split("P");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "P" + String.format("%02d", id);
        }
        return "P01";
    }

    public static List<String> loadCodes() throws SQLException {
        String sql = "SELECT code FROM item  ORDER BY code ASC";
        ResultSet resultSet = CrudUtil.execute(sql);

        List<String> data = new ArrayList<>();
        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }

    public static ItemDTO searchById(String itemCode) throws SQLException {
        String sql = "SELECT * FROM item WHERE code = ?";
        ResultSet resultSet = CrudUtil.execute(sql, itemCode);

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
    public static boolean updateQty(List<OrderDTO> orderDTOList) throws SQLException {
        for (OrderDTO orderDTODetails : orderDTOList) {
            if (!updateQty(orderDTODetails)) {
                return false;
            }
        }
        return true;
    }

    private static boolean updateQty(OrderDTO orderDTODetails) throws SQLException {
        String sql = "UPDATE item SET qtyOnHand = (qtyOnHand - ?) WHERE code = ?";
        Integer affectedRows = CrudUtil.execute(sql, orderDTODetails.getQty(), orderDTODetails.getCode());
        return affectedRows > 0;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////    Custom Build
    public static boolean updateBuildQty(List<CustombuildsDTO> buildsList) throws SQLException {
        for (CustombuildsDTO custombuildsDTO : buildsList) {
            if (!updateBuildQty(custombuildsDTO)) {
                return false;
            }
        }
        return true;
    }

    private static boolean updateBuildQty(CustombuildsDTO buildsList) throws SQLException {
        String sql = "UPDATE item SET qtyOnHand = (qtyOnHand - ?) WHERE code = ?";
        Integer affectedRows = CrudUtil.execute(sql, buildsList.getQty(), buildsList.getCode());
        return affectedRows > 0;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////    Suppliers
    public static boolean updateSupplyQty(String itemCode,String supplyQty) throws SQLException {
        String sql = "UPDATE item SET qtyOnHand = (qtyOnHand + ?) WHERE code = ?";
        Integer affectedRows = CrudUtil.execute(sql, supplyQty, itemCode);
        return affectedRows > 0;
    }
}
