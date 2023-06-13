package lk.ijse.computershop.model;

import lk.ijse.computershop.dto.SalaryDTO;
import lk.ijse.computershop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryModel {

    public static List<SalaryDTO> getAll() throws SQLException {

        List<SalaryDTO> salaryDTOList = new ArrayList<>();
        String sql = "SELECT * FROM salary";
        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()) {
            SalaryDTO salaryDTO = new SalaryDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getDate(4).toLocalDate()
            );
            salaryDTOList.add(salaryDTO);
        }
        return salaryDTOList;
    }

    public static String getNextSalaryCode() throws SQLException {
        String sql = "SELECT code FROM salary ORDER BY code DESC LIMIT 1";
        ResultSet resultSet = CrudUtil.execute(sql);

        if (resultSet.next()) {
            return splitSalaryCode(resultSet.getString(1));
        }
        return splitSalaryCode(null);
    }

    private static String splitSalaryCode(String currentId) {
        if (currentId != null) {
            String[] strings = currentId.split("S");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "S" + String.format("%02d", id);
        }
        return "S01";
    }
}
