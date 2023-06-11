package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.SalaryDAO;
import lk.ijse.computershop.entity.Salary;

import java.sql.SQLException;
import java.util.List;

public class SalaryDAOImpl implements SalaryDAO {

    @Override
    public List<Salary> loadAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Salary entity) throws SQLException {
        return 0;
    }

    @Override
    public Salary search(String id) throws SQLException {
        return null;
    }

    @Override
    public int update(Salary entity) throws SQLException {
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
