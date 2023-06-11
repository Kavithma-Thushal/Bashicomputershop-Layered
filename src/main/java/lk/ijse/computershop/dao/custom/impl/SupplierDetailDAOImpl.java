package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.SupplierDetailDAO;
import lk.ijse.computershop.dao.custom.impl.util.SQLUtil;
import lk.ijse.computershop.entity.Supplier_Details;

import java.sql.SQLException;
import java.util.List;

public class SupplierDetailDAOImpl implements SupplierDetailDAO {

    @Override
    public int save(Supplier_Details entity) throws SQLException {
        String sql = "INSERT INTO supplier_details VALUES(?, ?, ?, ?)";
        return SQLUtil.execute(sql, entity.getSupplierId(), entity.getItemCode(), entity.getQty(), entity.getDate());
    }

    @Override
    public Supplier_Details search(String id) throws SQLException {
        return null;
    }

    @Override
    public int update(Supplier_Details entity) throws SQLException {
        return 0;
    }

    @Override
    public int delete(String id) throws SQLException {
        return 0;
    }

    @Override
    public List<Supplier_Details> loadAll() throws SQLException {
        return null;
    }

    @Override
    public String generateNextId() throws SQLException {
        return null;
    }
}
