package lk.ijse.computershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Build_DetailsDTO {
    private String buildCode;
    private String itemCode;
    private Integer qty;
    private Double total;
    private String date;
}
