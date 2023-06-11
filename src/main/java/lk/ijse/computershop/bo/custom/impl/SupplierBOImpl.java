package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.SupplierBO;
import lk.ijse.computershop.dao.DAOFactory;
import lk.ijse.computershop.dao.custom.impl.ItemDAOImpl;
import lk.ijse.computershop.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.computershop.dao.custom.impl.SupplierDetailDAOImpl;
import lk.ijse.computershop.db.DBConnection;
import lk.ijse.computershop.dto.ItemDTO;
import lk.ijse.computershop.dto.SupplierDTO;
import lk.ijse.computershop.entity.Supplier;
import lk.ijse.computershop.entity.Supplier_Details;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierBOImpl implements SupplierBO {

    private ItemDAOImpl itemDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    private SupplierDAOImpl supplierDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);
    private SupplierDetailDAOImpl supplierDetailDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.SUPPLIERDETAIL);

    /*Transaction*/
    @Override
    public boolean addSupplier(String supplierId, String supplyDate, String name, String contact, String address, String itemCode, String supplyQty) throws SQLException {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isUpdated = itemDAO.updateSupplyQty(itemCode, supplyQty);     //items update
            if (isUpdated) {
                Integer isSaved = supplierDAO.save(new Supplier(supplierId, name, contact, address));     //suppliers
                if (isSaved>0) {
                    Integer isOrdered = supplierDetailDAO.save(new Supplier_Details(supplierId, itemCode, supplyQty, supplyDate));      //supplier_details
                    if (isOrdered>0) {
                        connection.commit();
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public List<SupplierDTO> loadAllSuppliers() throws SQLException {
        List<SupplierDTO> supplierDTOS = new ArrayList<>();
        List<Supplier> suppliers = supplierDAO.loadAll();
        for (Supplier s : suppliers) {
            supplierDTOS.add(new SupplierDTO(s.getId(),s.getName(),s.getContact(),s.getAddress()));
        }
        return supplierDTOS;
    }

    @Override
    public String generateNextSupplierId() throws SQLException {
        return supplierDAO.generateNextId();
    }

    @Override
    public List<String> loadItemCodes() throws SQLException {
        return itemDAO.loadItemCodes();
    }

    @Override
    public ItemDTO searchByItemCode(String itemCode) throws SQLException {
        return itemDAO.searchByItemCode(itemCode);
    }
}
