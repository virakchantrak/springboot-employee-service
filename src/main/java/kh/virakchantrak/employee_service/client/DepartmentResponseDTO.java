package kh.virakchantrak.employee_service.client;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class DepartmentResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String departmentCode;
}
