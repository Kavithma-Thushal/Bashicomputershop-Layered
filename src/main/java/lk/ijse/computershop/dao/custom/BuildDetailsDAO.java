package lk.ijse.computershop.dao.custom;

import lk.ijse.computershop.dao.CrudDAO;
import lk.ijse.computershop.dto.CustombuildsDTO;
import lk.ijse.computershop.entity.Build_Details;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface BuildDetailsDAO extends CrudDAO<Build_Details> {
    boolean saveBuild(String buildCode, List<CustombuildsDTO> buildsList, LocalDate date) throws SQLException;
}
