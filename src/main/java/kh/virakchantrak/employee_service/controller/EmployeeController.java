package kh.virakchantrak.employee_service.controller;

import jakarta.validation.Valid;
import kh.virakchantrak.employee_service.dto.EmployeeRequestDTO;
import kh.virakchantrak.employee_service.dto.EmployeeResponseDTO;
import kh.virakchantrak.employee_service.dto.EmployeeWithDepartmentResponseDTO;
import kh.virakchantrak.employee_service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeResponseDTO create(@Valid @RequestBody EmployeeRequestDTO requestDTO) {
        return employeeService.create(requestDTO);
    }

    @GetMapping("/{id}")
    public EmployeeResponseDTO getById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @GetMapping("/{id}/with-department")
    public EmployeeWithDepartmentResponseDTO getEmployeeWithDepartment(@PathVariable Long id) {
        return employeeService.getEmployeeWithDepartment(id);
    }

    @GetMapping
    public Page<EmployeeResponseDTO> getAllDepartments(Pageable pageable) {
        return employeeService.getAllDepartments(pageable);
    }
}
