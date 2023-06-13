/*
package lk.ijse.computershop.model;

import lk.ijse.computershop.dto.DeliveryDTO;
import lk.ijse.computershop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryModel {

    public static List<DeliveryDTO> getAll() throws SQLException {

        List<DeliveryDTO> deliveryDTOList = new ArrayList<>();
        String sql = "SELECT * FROM delivery";
        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()) {
            DeliveryDTO deliveryDTO = new DeliveryDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getDate(6).toLocalDate()
            );
            deliveryDTOList.add(deliveryDTO);
        }
        return deliveryDTOList;
    }

    public static String getNextDeliveryCode() throws SQLException {
        String sql = "SELECT code FROM delivery ORDER BY code DESC LIMIT 1";
        ResultSet resultSet = CrudUtil.execute(sql);

        if (resultSet.next()) {
            return splitDeliveryCode(resultSet.getString(1));
        }
        return splitDeliveryCode(null);
    }

    private static String splitDeliveryCode(String currentId) {
        if (currentId != null) {
            String[] strings = currentId.split("D");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "D" + String.format("%02d", id);
        }
        return "D01";
    }
}
*/
