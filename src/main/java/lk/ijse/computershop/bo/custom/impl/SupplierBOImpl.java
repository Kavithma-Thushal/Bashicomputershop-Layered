package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.SupplierBO;
import lk.ijse.computershop.dto.ItemDTO;
import lk.ijse.computershop.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.List;

public class SupplierBOImpl implements SupplierBO {

    @Override
    public List<SupplierDTO> loadAllSuppliers() throws SQLException {
        return null;
    }

    @Override
    public String generateNextSupplierId() throws SQLException {
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
    public boolean addSupplier(String supplierId, String supplyDate, String name, String contact, String address, String itemCode, String supplyQty) throws SQLException {
        return false;
    }
}
