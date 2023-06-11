package lk.ijse.computershop.bo.custom;

import lk.ijse.computershop.bo.SuperBO;
import lk.ijse.computershop.dto.ItemDTO;
import lk.ijse.computershop.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.List;

public interface SupplierBO extends SuperBO {

    List<SupplierDTO> loadAllSuppliers() throws SQLException;

    String generateNextSupplierId() throws SQLException;

    List<String> loadItemCodes() throws SQLException;

    ItemDTO searchByItemCode(String itemCode) throws SQLException;

    boolean addSupplier(SupplierDTO supplierDTO) throws SQLException;
}
