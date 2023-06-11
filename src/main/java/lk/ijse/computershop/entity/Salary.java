package lk.ijse.computershop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Salary {
    private String code;
    private String employeeId;
    private Double amount;
    private String date;
}
