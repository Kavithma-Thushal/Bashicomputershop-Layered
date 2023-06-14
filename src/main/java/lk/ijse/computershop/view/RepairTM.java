package lk.ijse.computershop.view;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RepairTM {
    private String code;
    private String customerId;
    private String employeeId;
    private String details;
    private String gettingDate;
    private String acceptingDate;
}
