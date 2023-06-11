package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.BuildDetailsDAO;
import lk.ijse.computershop.dto.CustombuildsDTO;
import lk.ijse.computershop.entity.Build_Details;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class BuildDetailsDAOImpl implements BuildDetailsDAO {

    @Override
    public List<Build_Details> loadAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Build_Details entity) throws SQLException {
        return 0;
    }

    @Override
    public Build_Details search(String id) throws SQLException {
        return null;
    }

    @Override
    public int update(Build_Details entity) throws SQLException {
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
    public boolean buildQuotation(String buildCode, List<CustombuildsDTO> buildsDTOList, LocalDate date) throws SQLException {
        return false;
    }
}
