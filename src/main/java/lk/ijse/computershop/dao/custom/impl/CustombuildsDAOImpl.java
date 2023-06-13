package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.CustombuildsDAO;
import lk.ijse.computershop.dao.custom.impl.util.SQLUtil;
import lk.ijse.computershop.entity.Custombuilds;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustombuildsDAOImpl implements CustombuildsDAO {

    @Override
    public List<Custombuilds> loadAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Custombuilds b) throws SQLException {
        return SQLUtil.execute("INSERT INTO custombuilds(code, customerId, employeeId) VALUES(?, ? ,?)",b.getCode(),b.getCustomerId(),b.getEmployeeId());
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
        ResultSet rst=SQLUtil.execute("SELECT code FROM custombuilds ORDER BY code DESC LIMIT 1");
        if (rst.next()) {
            return splitBuildCode(rst.getString(1));
        }
        return splitBuildCode(null);
    }

    private static String splitBuildCode(String currentId) {
        if (currentId != null) {
            String[] strings = currentId.split("B");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "B" + String.format("%02d", id);
        }
        return "B01";
    }
}
