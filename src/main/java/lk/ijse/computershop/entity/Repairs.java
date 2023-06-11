package lk.ijse.computershop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Repairs {
    private String code;
    private String customerId;
    private String employeeId;
    private String details;
    private String getDate;
    private String acceptDate;
}
