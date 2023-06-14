package lk.ijse.computershop.view;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemTM {
    private String code;
    private String description;
    private Double unitPrice;
    private Integer qtyOnHand;
}
