package lk.ijse.computershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BuildDTO {
    private String code;
    private String customerId;
    private String employeeId;
    private List<Build_DetailsDTO> buildDetailsDTOList;
}
