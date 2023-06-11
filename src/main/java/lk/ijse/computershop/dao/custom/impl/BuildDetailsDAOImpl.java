package lk.ijse.computershop.dao.custom.impl;

import lk.ijse.computershop.dao.custom.BuildDetailsDAO;
import lk.ijse.computershop.dao.custom.impl.util.SQLUtil;
import lk.ijse.computershop.dto.CustombuildsDTO;
import lk.ijse.computershop.entity.Build_Details;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class BuildDetailsDAOImpl implements BuildDetailsDAO {

    @Override
    public boolean saveBuild(String buildCode, List<CustombuildsDTO> buildsList, LocalDate date) throws SQLException {
        for (CustombuildsDTO custombuildsDTO : buildsList) {
            if (!saveBuild(buildCode, custombuildsDTO, LocalDate.now())) {
                return false;
            }
        }
        return true;
    }

    private boolean saveBuild(String buildCode, CustombuildsDTO custombuildsDTO, LocalDate date) throws SQLException {
        String sql = "INSERT INTO build_details VALUES(?, ?, ?, ?,?)";
        Integer affectedRows = SQLUtil.execute(sql, buildCode, custombuildsDTO.getCode(), custombuildsDTO.getQty(), custombuildsDTO.getTotal(), Date.valueOf(date));
        return affectedRows > 0;
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
    public List<Build_Details> getAll() throws SQLException {
        return null;
    }

    @Override
    public String getNextId() throws SQLException {
        return null;
    }
}
