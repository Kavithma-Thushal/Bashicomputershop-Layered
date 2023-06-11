package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.DeliveryDAO;
import lk.ijse.computershop.entity.Delivery;

import java.sql.SQLException;
import java.util.List;

public class DeliveryDAOImpl implements DeliveryDAO {

    @Override
    public List<Delivery> loadAll() throws SQLException {
        return null;
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

    @Override
    public String generateNextId() throws SQLException {
        return null;
    }
}
