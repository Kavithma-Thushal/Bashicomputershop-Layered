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
    public List<Repairs> loadAll() throws SQLException {
        List<Repairs> repairsList=new ArrayList<>();
        ResultSet rst= SQLUtil.execute("SELECT * FROM repairs");
        while (rst.next()){
            Repairs repairs=new Repairs(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getDate(5).toLocalDate(),rst.getDate(6).toLocalDate());
            repairsList.add(repairs);
        }
        return repairsList;
    }

    @Override
    public int save(Repairs r) throws SQLException {
        return SQLUtil.execute("INSERT INTO repairs VALUES(?, ?, ?, ?, ?, ?)",r.getCode(),r.getCustomerId(),r.getEmployeeId(),r.getDetails(),r.getGetDate(),r.getAcceptDate());
    }

    @Override
    public Repairs search(String code) throws SQLException {
        ResultSet rst=SQLUtil.execute("SELECT * FROM repairs WHERE code=?",code);
        if (rst.next()){
            return new Repairs(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getDate(5).toLocalDate(),rst.getDate(6).toLocalDate());
        }
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
        ResultSet rst=SQLUtil.execute("SELECT code FROM repairs ORDER BY code DESC LIMIT 1");
        if (rst.next()) {
            return splitRepairCode(rst.getString(1));
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
}
