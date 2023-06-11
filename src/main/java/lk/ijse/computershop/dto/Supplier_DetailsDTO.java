package lk.ijse.computershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Supplier_DetailsDTO {
    private String supplierId;
    private String itemCode;
    private Integer qty;
    private String date;
}
