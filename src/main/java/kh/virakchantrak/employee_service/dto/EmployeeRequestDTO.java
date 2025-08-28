package kh.virakchantrak.employee_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeRequestDTO {

    @NotNull
    private String name;
    @NotNull
    private String email;
    private String position;
    @NotNull
    private String departmentCode;
}
