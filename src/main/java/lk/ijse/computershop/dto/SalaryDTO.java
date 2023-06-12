package lk.ijse.computershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class SalaryDTO {
    private String code;
    private String employeeId;
    private Double amount;
    private LocalDate date;
}
