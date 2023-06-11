package lk.ijse.computershop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Supplier_Details {
    private String supplierId;
    private String itemCode;
    private String qty;
    private String date;
}
