package lk.ijse.computershop.bo.custom;

import lk.ijse.computershop.bo.SuperBO;
import lk.ijse.computershop.dto.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public interface ItemBO extends SuperBO {

    int save(ItemDTO itemDTO) throws SQLException;

    ItemDTO search(String code) throws SQLException;

    int update(ItemDTO itemDTO) throws SQLException;

    int delete(String code) throws SQLException;

    List<ItemDTO> getAll() throws SQLException;

    String getNextId() throws SQLException;

    List<String> loadCodes() throws SQLException;

    ItemDTO searchById(String itemCode) throws SQLException;
}
