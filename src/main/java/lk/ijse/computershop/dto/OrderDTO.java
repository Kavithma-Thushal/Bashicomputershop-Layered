package lk.ijse.computershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDTO {
    private String code;
    private Integer qty;
    private Double total;

    private String orderId;
    private String customerId;

    public OrderDTO(String code, Integer qty, Double total) {
        this.code = code;
        this.qty = qty;
        this.total = total;
    }
}
