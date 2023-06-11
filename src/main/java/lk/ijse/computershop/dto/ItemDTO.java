package lk.ijse.computershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDTO {
    private String code;
    private String description;
    private Double unitPrice;
    private Integer qtyOnHand;
}
