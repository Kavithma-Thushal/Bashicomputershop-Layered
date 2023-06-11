package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.EmployeeDAO;
import lk.ijse.computershop.dao.custom.impl.util.SQLUtil;
import lk.ijse.computershop.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public int save(Employee entity) throws SQLException {
        String sql = "INSERT INTO employee VALUES (?,?,?,?,?,?)";

        return SQLUtil.execute(
                sql,
                entity.getId(),
                entity.getName(),
                entity.getContact(),
                entity.getJobRole(),
                entity.getUsername(),
                entity.getPassword()
        );

    }

    @Override
    public Employee search(String id) throws SQLException {
        String sql = "SELECT * FROM employee WHERE id=?";

        ResultSet resultSet = SQLUtil.execute(sql, id);
        if (resultSet.next()) {
            return new Employee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
        }
        return null;
    }

    @Override
    public int update(Employee entity) throws SQLException {
        String sql = "UPDATE employee SET name=? , contact=? , jobRole=? , username=? , password=? WHERE id=?";

        return SQLUtil.execute(
                sql,
                entity.getName(),
                entity.getContact(),
                entity.getJobRole(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getId()
        );
    }

    @Override
    public int delete(String id) throws SQLException {
        String sql = "DELETE FROM employee WHERE id=?";
        return SQLUtil.execute(sql, id);
    }

    @Override
    public List<Employee> getAll() throws SQLException {

        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        ResultSet resultSet = SQLUtil.execute(sql);

        while (resultSet.next()) {
            Employee employee = new Employee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    public String getNextId() throws SQLException {
        String sql = "SELECT id FROM employee ORDER BY id DESC LIMIT 1";
        ResultSet resultSet = SQLUtil.execute(sql);

        if (resultSet.next()) {
            return splitEmployeeId(resultSet.getString(1));
        }
        return splitEmployeeId(null);
    }

    private String splitEmployeeId(String currentId) {
        if (currentId != null) {
            String[] strings = currentId.split("E");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "E" + String.format("%02d", id);
        }
        return "E01";
    }

    @Override
    public List<String> loadIds() throws SQLException {
        String sql = "SELECT id FROM employee WHERE   jobRole IN ('Technician','technician') ORDER BY id ASC";
        ResultSet resultSet = SQLUtil.execute(sql);

        List<String> data = new ArrayList<>();
        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }

    @Override
    public List<String> loadEmployeeIds() throws SQLException {
        String sql = "SELECT id FROM employee ORDER BY id ASC";
        ResultSet resultSet = SQLUtil.execute(sql);

        List<String> data = new ArrayList<>();
        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }

    @Override
    public Employee searchById(String employeeId) throws SQLException {
        String sql = "SELECT * FROM employee WHERE id = ?";
        ResultSet resultSet = SQLUtil.execute(sql, employeeId);

        if (resultSet.next()) {
            return new Employee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
        }
        return null;
    }
}
