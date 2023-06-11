package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.DeliveryDAO;
import lk.ijse.computershop.dao.custom.impl.util.SQLUtil;
import lk.ijse.computershop.entity.Delivery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAOImpl implements DeliveryDAO {

    @Override
    public List<Delivery> getAll() throws SQLException {

        List<Delivery> deliveryList = new ArrayList<>();
        String sql = "SELECT * FROM delivery";
        ResultSet resultSet = SQLUtil.execute(sql);

        while (resultSet.next()) {
            Delivery delivery = new Delivery(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
            deliveryList.add(delivery);
        }
        return deliveryList;
    }

    @Override
    public String getNextId() throws SQLException {
        String sql = "SELECT code FROM delivery ORDER BY code DESC LIMIT 1";
        ResultSet resultSet = SQLUtil.execute(sql);

        if (resultSet.next()) {
            return splitDeliveryCode(resultSet.getString(1));
        }
        return splitDeliveryCode(null);
    }

    private String splitDeliveryCode(String currentId) {
        if (currentId != null) {
            String[] strings = currentId.split("D");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "D" + String.format("%02d", id);
        }
        return "D01";
    }

    @Override
    public int save(Delivery entity) throws SQLException {
        return 0;
    }

    @Override
    public Delivery search(String id) throws SQLException {
        return null;
    }

    @Override
    public int update(Delivery entity) throws SQLException {
        return 0;
    }

    @Override
    public int delete(String id) throws SQLException {
        return 0;
    }
}
