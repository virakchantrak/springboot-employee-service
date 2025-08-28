package kh.virakchantrak.employee_service.dto;

import kh.virakchantrak.employee_service.client.DepartmentResponseDTO;
import lombok.Data;

@Data
public class EmployeeWithDepartmentResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String position;
    private DepartmentResponseDTO department;
}
