package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.CustombuildsDAO;
import lk.ijse.computershop.dao.custom.impl.util.SQLUtil;
import lk.ijse.computershop.entity.Custombuilds;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustombuildsDAOImpl implements CustombuildsDAO {

    @Override
    public int save(Custombuilds entity) throws SQLException {
        String sql = "INSERT INTO custombuilds(code, customerId, employeeId) VALUES(?, ? ,?)";
        return SQLUtil.execute(sql, entity.getCode(), entity.getCustomerId(), entity.getEmployeeId());
    }

    @Override
    public String getNextId() throws SQLException {
        String sql = "SELECT code FROM custombuilds ORDER BY code DESC LIMIT 1";
        ResultSet resultSet = SQLUtil.execute(sql);

        if (resultSet.next()) {
            return splitBuildCode(resultSet.getString(1));
        }
        return splitBuildCode(null);
    }

    private String splitBuildCode(String currentId) {
        if (currentId != null) {
            String[] strings = currentId.split("B");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "B" + String.format("%02d", id);
        }
        return "B01";
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
    public List<Custombuilds> getAll() throws SQLException {
        return null;
    }
}
