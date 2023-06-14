package lk.ijse.computershop.view;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SalaryTM {
    private String code;
    private String employeeName;
    private Double amount;
    private String date;
}
