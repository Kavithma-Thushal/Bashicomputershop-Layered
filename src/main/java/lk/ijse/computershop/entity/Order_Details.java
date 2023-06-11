package lk.ijse.computershop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order_Details {
    private String orderId;
    private String itemCode;
    private Integer qty;
    private Double total;
    private String date;
}
