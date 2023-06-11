package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.RepairDAO;
import lk.ijse.computershop.dao.custom.impl.util.SQLUtil;
import lk.ijse.computershop.entity.Repairs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepairDAOImpl implements RepairDAO {

    @Override
    public Repairs search(String code) throws SQLException {

        String sql = "SELECT * FROM repairs WHERE code=?";

        ResultSet resultSet = SQLUtil.execute(sql, code);

        if (resultSet.next()) {
            return new Repairs(
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
    public List<Repairs> loadAll() throws SQLException {

        List<Repairs> repairDTOList = new ArrayList<>();
        String sql = "SELECT * FROM repairs";
        ResultSet resultSet = SQLUtil.execute(sql);

        while (resultSet.next()) {
            Repairs repairs = new Repairs(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
            repairDTOList.add(repairs);
        }
        return repairDTOList;
    }

    @Override
    public String generateNextId() throws SQLException {
        String sql = "SELECT code FROM repairs ORDER BY code DESC LIMIT 1";
        ResultSet resultSet = SQLUtil.execute(sql);

        if (resultSet.next()) {
            return splitRepairCode(resultSet.getString(1));
        }
        return splitRepairCode(null);
    }

    private String splitRepairCode(String currentId) {
        if (currentId != null) {
            String[] strings = currentId.split("R");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "R" + String.format("%02d", id);
        }
        return "R01";
    }

    @Override
    public int save(Repairs entity) throws SQLException {
        return 0;
    }

    @Override
    public int update(Repairs entity) throws SQLException {
        return 0;
    }

    @Override
    public int delete(String id) throws SQLException {
        return 0;
    }
}
