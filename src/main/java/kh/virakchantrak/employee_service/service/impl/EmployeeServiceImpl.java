package kh.virakchantrak.employee_service.service.impl;

import kh.virakchantrak.employee_service.client.DepartmentClient;
import kh.virakchantrak.employee_service.client.DepartmentResponseDTO;
import kh.virakchantrak.employee_service.common.ErrorCode;
import kh.virakchantrak.employee_service.dto.EmployeeRequestDTO;
import kh.virakchantrak.employee_service.dto.EmployeeResponseDTO;
import kh.virakchantrak.employee_service.dto.EmployeeWithDepartmentResponseDTO;
import kh.virakchantrak.employee_service.entity.EmployeeEntity;
import kh.virakchantrak.employee_service.mapper.EmployeeMapper;
import kh.virakchantrak.employee_service.repository.EmployeeRepo;
import kh.virakchantrak.employee_service.service.EmployeeService;
import kh.virakchantrak.library.exception.core.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final EmployeeMapper mapper;
    private final DepartmentClient departmentClient;

    @Override
    public EmployeeResponseDTO create(EmployeeRequestDTO requestDTO) {
        if (employeeRepo.existsByEmail(requestDTO.getEmail())) {
            throw new ApiException(ErrorCode.EMAIL_ALREADY_EXIST);
        }

        DepartmentResponseDTO departmentResponseDTO = departmentClient.getDepartmentByCode(requestDTO.getDepartmentCode());
        if (departmentResponseDTO == null) {
            throw new ApiException(ErrorCode.DEPARTMENT_CODE_NOT_FOUND);
        }

        EmployeeEntity employeeEntity = mapper.toEntity(requestDTO);
        EmployeeEntity savedEntity = employeeRepo.save(employeeEntity);
        return mapper.toResponseDTO(savedEntity);
    }

    @Override
    public EmployeeResponseDTO getById(Long id) {
        EmployeeEntity employeeEntity = employeeRepo.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_FOUND));
        return mapper.toResponseDTO(employeeEntity);
    }

    @Override
    public EmployeeWithDepartmentResponseDTO getEmployeeWithDepartment(Long id) {
        EmployeeEntity employeeEntity = employeeRepo.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_FOUND));

        DepartmentResponseDTO departmentResponseDTO = departmentClient.getDepartmentByCode(employeeEntity.getDepartmentCode());

        return mapper.toResponseDTO(employeeEntity, departmentResponseDTO);
    }

    @Override
    public Page<EmployeeResponseDTO> getAllDepartments(Pageable pageable) {
        return employeeRepo.findAll(pageable).map(mapper::toResponseDTO);
    }
}
