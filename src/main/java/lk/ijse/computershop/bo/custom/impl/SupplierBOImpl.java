package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.SupplierBO;
import lk.ijse.computershop.dao.DAOFactory;
import lk.ijse.computershop.dao.custom.SupplierDAO;
import lk.ijse.computershop.dao.custom.SupplierDetailDAO;
import lk.ijse.computershop.db.DBConnection;
import lk.ijse.computershop.dto.ItemDTO;
import lk.ijse.computershop.dto.SupplierDTO;
import lk.ijse.computershop.dto.Supplier_DetailsDTO;
import lk.ijse.computershop.entity.Supplier;
import lk.ijse.computershop.entity.Supplier_Details;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierBOImpl implements SupplierBO {

    private SupplierDAO supplierDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);
    private SupplierDetailDAO supplierDetailDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.SUPPLIERDETAIL);

    @Override
    public List<SupplierDTO> loadAllSuppliers() throws SQLException {
        List<SupplierDTO> arrayList = new ArrayList<>();
        List<Supplier> suppliers = supplierDAO.loadAll();
        for (Supplier s : suppliers) {
            arrayList.add(new SupplierDTO(s.getId(), s.getName(), s.getContact(), s.getAddress()));
        }
        return arrayList;
    }

    @Override
    public String generateNextSupplierId() throws SQLException {
        return supplierDAO.generateNextId();
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
    public boolean addSupplier(SupplierDTO dto) {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            connection.setAutoCommit(false);
            Integer supplier_Save = supplierDAO.save(new Supplier(dto.getId(), dto.getName(), dto.getContact(), dto.getAddress()));
            if (supplier_Save > 0) {
                boolean success = true;
                for (Supplier_DetailsDTO s : dto.getSupplier_DetailsDTOList()) {
                    Integer supplierDetails_Save = supplierDetailDAO.save(new Supplier_Details(s.getSupplierId(), s.getItemCode(), s.getQty(), s.getDate()));
                    if (supplierDetails_Save <= 0) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    connection.commit();
                    connection.setAutoCommit(true);
                    return true;
                }
            }
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
