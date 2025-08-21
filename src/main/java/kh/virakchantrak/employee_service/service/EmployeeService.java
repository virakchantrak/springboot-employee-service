package kh.virakchantrak.employee_service.service;

import kh.virakchantrak.employee_service.dto.EmployeeRequestDTO;
import kh.virakchantrak.employee_service.dto.EmployeeResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    EmployeeResponseDTO create(EmployeeRequestDTO requestDTO);
    EmployeeResponseDTO getById(Long id);
    Page<EmployeeResponseDTO> getAllDepartments(Pageable pageable);
}
