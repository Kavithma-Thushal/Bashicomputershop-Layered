package lk.ijse.computershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DeliveryDTO {
    private String code;
    private String customerId;
    private String employeeId;
    private String orderId;
    private String location;
    private LocalDate date;
}
