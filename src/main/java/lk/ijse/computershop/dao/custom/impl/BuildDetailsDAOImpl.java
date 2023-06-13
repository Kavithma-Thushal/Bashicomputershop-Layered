package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.BuildDetailsDAO;
import lk.ijse.computershop.dao.custom.impl.util.SQLUtil;
import lk.ijse.computershop.entity.Build_Details;

import java.sql.SQLException;
import java.util.List;

public class BuildDetailsDAOImpl implements BuildDetailsDAO {

    @Override
    public List<Build_Details> loadAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Build_Details b) throws SQLException {
        return SQLUtil.execute("INSERT INTO build_details VALUES(?, ?, ?, ?,?)",b.getBuildCode(),b.getItemCode(),b.getQty(),b.getTotal(),b.getDate());
    }

    @Override
    public Build_Details search(String id) throws SQLException {
        return null;
    }

    @Override
    public int update(Build_Details entity) throws SQLException {
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
