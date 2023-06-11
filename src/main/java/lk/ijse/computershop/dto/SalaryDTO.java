package lk.ijse.computershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SalaryDTO {
    private String code;
    private String employeeName;
    private Double amount;
    private String date;
}
