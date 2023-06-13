package lk.ijse.computershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderDTO {
    private String orderId;
    private String customerId;
    private List<Order_DetailsDTO> order_detailsDTOList;

    public OrderDTO(String orderId, String customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }
}
