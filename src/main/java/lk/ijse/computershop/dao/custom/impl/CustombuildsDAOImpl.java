package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.CustombuildsDAO;
import lk.ijse.computershop.entity.Custombuilds;

import java.sql.SQLException;
import java.util.List;

public class CustombuildsDAOImpl implements CustombuildsDAO {

    @Override
    public List<Custombuilds> loadAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Custombuilds entity) throws SQLException {
        return 0;
    }

    @Override
    public Custombuilds search(String id) throws SQLException {
        return null;
    }

    @Override
    public int update(Custombuilds entity) throws SQLException {
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
