package kh.virakchantrak.employee_service.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class EmployeeResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String position;
    private String departmentCode;
}
