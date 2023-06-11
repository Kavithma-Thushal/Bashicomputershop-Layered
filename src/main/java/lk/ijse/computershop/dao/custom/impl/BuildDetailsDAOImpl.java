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
    public boolean buildQuotation(String buildCode, List<CustombuildsDTO> buildsDTOList, LocalDate date) throws SQLException {
        for (CustombuildsDTO custombuildsDTO : buildsDTOList) {
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
    public List<Build_Details> loadAll() throws SQLException {
        return null;
    }

    @Override
    public String generateNextId() throws SQLException {
        return null;
    }
}
