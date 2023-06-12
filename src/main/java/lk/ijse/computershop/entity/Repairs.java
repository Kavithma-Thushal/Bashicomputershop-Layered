package lk.ijse.computershop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Repairs {
    private String code;
    private String customerId;
    private String employeeId;
    private String details;
    private LocalDate getDate;
    private LocalDate acceptDate;
}
