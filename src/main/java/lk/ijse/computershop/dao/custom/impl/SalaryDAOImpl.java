package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.SalaryDAO;
import lk.ijse.computershop.dao.custom.impl.util.SQLUtil;
import lk.ijse.computershop.entity.Salary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryDAOImpl implements SalaryDAO {

    @Override
    public List<Salary> loadAll() throws SQLException {

        List<Salary> salaryList = new ArrayList<>();
        String sql = "SELECT * FROM salary";
        ResultSet resultSet = SQLUtil.execute(sql);

        while (resultSet.next()) {
            Salary salary = new Salary(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getString(4)
            );
            salaryList.add(salary);
        }
        return salaryList;
    }

    @Override
    public String generateNextId() throws SQLException {
        String sql = "SELECT code FROM salary ORDER BY code DESC LIMIT 1";
        ResultSet resultSet = SQLUtil.execute(sql);

        if (resultSet.next()) {
            return splitSalaryCode(resultSet.getString(1));
        }
        return splitSalaryCode(null);
    }

    private String splitSalaryCode(String currentId) {
        if (currentId != null) {
            String[] strings = currentId.split("S");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "S" + String.format("%02d", id);
        }
        return "S01";
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
}
