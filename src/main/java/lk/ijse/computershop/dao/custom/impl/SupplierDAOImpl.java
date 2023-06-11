package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.SupplierDAO;
import lk.ijse.computershop.entity.Supplier;

import java.sql.SQLException;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public List<Supplier> loadAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Supplier entity) throws SQLException {
        return 0;
    }

    @Override
    public Supplier search(String id) throws SQLException {
        return null;
    }

    @Override
    public int update(Supplier entity) throws SQLException {
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
}
