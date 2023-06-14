package lk.ijse.computershop.view;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeliveryTM {
    private String code;
    private String customerId;
    private String employeeId;
    private String orderId;
    private String location;
    private String date;
}
