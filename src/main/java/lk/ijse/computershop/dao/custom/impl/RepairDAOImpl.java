package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.RepairDAO;
import lk.ijse.computershop.entity.Repairs;

import java.sql.SQLException;
import java.util.List;

public class RepairDAOImpl implements RepairDAO {

    @Override
    public List<Repairs> loadAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Repairs entity) throws SQLException {
        return 0;
    }

    @Override
    public Repairs search(String id) throws SQLException {
        return null;
    }

    @Override
    public int update(Repairs entity) throws SQLException {
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
