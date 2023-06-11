package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.EmployeeDAO;
import lk.ijse.computershop.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public List<Employee> loadAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Employee entity) throws SQLException {
        return 0;
    }

    @Override
    public Employee search(String id) throws SQLException {
        return null;
    }

    @Override
    public int update(Employee entity) throws SQLException {
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

    @Override
    public List<String> loadEmployeeIds() throws SQLException {
        return null;
    }

    @Override
    public Employee searchByEmployeeId(String employeeId) throws SQLException {
        return null;
    }

    @Override
    public List<String> loadEmployeeIdsToRepair() throws SQLException {
        return null;
    }
}
