/*
package lk.ijse.computershop.model;

import lk.ijse.computershop.dto.CustombuildsDTO;
import lk.ijse.computershop.util.CrudUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class BuildDetailsModel {

    public static boolean saveBuild(String buildCode, List<CustombuildsDTO> buildsList, LocalDate date) throws SQLException {
        for (CustombuildsDTO custombuildsDTO : buildsList) {
            if (!saveBuild(buildCode, custombuildsDTO, LocalDate.now())) {
                return false;
            }
        }
        return true;
    }

    private static boolean saveBuild(String buildCode, CustombuildsDTO custombuildsDTO, LocalDate date) throws SQLException {
        String sql = "INSERT INTO build_details VALUES(?, ?, ?, ?,?)";
        Integer affectedRows = CrudUtil.execute(sql, buildCode, custombuildsDTO.getCode(), custombuildsDTO.getQty(), custombuildsDTO.getTotal(), Date.valueOf(date));
        return affectedRows > 0;
    }
}
*/
