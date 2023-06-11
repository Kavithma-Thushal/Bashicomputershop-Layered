package lk.ijse.computershop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Build_Details {
    private String buildCode;
    private String itemCode;
    private Integer qty;
    private Double total;
    private String date;
}
