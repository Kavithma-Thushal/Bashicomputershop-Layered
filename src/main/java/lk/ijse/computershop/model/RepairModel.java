package lk.ijse.computershop.model;

import lk.ijse.computershop.dto.RepairDTO;
import lk.ijse.computershop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepairModel {

    public static List<RepairDTO> getAll() throws SQLException {

        List<RepairDTO> repairDTOList = new ArrayList<>();
        String sql = "SELECT * FROM repairs";
        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()) {
            RepairDTO repairDTO = new RepairDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDate(5).toLocalDate(),
                    resultSet.getDate(6).toLocalDate()
            );
            repairDTOList.add(repairDTO);
        }
        return repairDTOList;
    }

    public static RepairDTO search(String code) throws SQLException {

        String sql = "SELECT * FROM repairs WHERE code=?";

        ResultSet resultSet = CrudUtil.execute(sql, code);

        if (resultSet.next()) {
            return new RepairDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDate(5).toLocalDate(),
                    resultSet.getDate(6).toLocalDate()
            );
        }
        return null;
    }

    public static String getNextDeliveryCode() throws SQLException {
        String sql = "SELECT code FROM repairs ORDER BY code DESC LIMIT 1";
        ResultSet resultSet = CrudUtil.execute(sql);

        if (resultSet.next()) {
            return splitRepairCode(resultSet.getString(1));
        }
        return splitRepairCode(null);
    }

    private static String splitRepairCode(String currentId) {
        if (currentId != null) {
            String[] strings = currentId.split("R");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "R" + String.format("%02d", id);
        }
        return "R01";
    }
}
