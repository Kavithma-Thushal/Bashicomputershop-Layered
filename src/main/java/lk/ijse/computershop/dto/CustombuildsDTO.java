package lk.ijse.computershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustombuildsDTO {
    private String code;
    private Integer qty;
    private Double total;

    private String customerId;
    private String employeeId;

    public CustombuildsDTO(String code, Integer qty, Double total) {
        this.code = code;
        this.qty = qty;
        this.total = total;
    }
}
