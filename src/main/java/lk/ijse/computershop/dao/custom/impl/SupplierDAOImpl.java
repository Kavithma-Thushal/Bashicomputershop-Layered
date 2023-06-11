package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.SupplierDAO;
import lk.ijse.computershop.dao.custom.impl.util.SQLUtil;
import lk.ijse.computershop.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public int save(Supplier entity) throws SQLException {
        String sql = "INSERT INTO supplier VALUES(?,?,?,?)";
        return SQLUtil.execute(sql, entity.getId(), entity.getName(), entity.getContact(), entity.getAddress());
    }

    @Override
    public List<Supplier> getAll() throws SQLException {

        List<Supplier> suppliers = new ArrayList<>();
        String sql = "SELECT * FROM supplier";
        ResultSet resultSet = SQLUtil.execute(sql);

        while (resultSet.next()) {
            Supplier supplier = new Supplier(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            );
            suppliers.add(supplier);
        }
        return suppliers;
    }

    @Override
    public String getNextId() throws SQLException {
        String sql = "SELECT id FROM supplier ORDER BY id DESC LIMIT 1";
        ResultSet resultSet = SQLUtil.execute(sql);

        if (resultSet.next()) {
            return splitSupplyId(resultSet.getString(1));
        }
        return splitSupplyId(null);
    }

    private String splitSupplyId(String currentId) {
        if (currentId != null) {
            String[] strings = currentId.split("S");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "S" + String.format("%02d", id);
        }
        return "S01";
    }

    @Override
    public Supplier search(String id) throws SQLException {
        return null;
    }

    @Override
    public int update(Supplier entity) throws SQLException {
        return 0;
    }

    @Override
    public int delete(String id) throws SQLException {
        return 0;
    }
}
