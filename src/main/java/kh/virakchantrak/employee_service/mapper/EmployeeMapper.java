package kh.virakchantrak.employee_service.mapper;

import kh.virakchantrak.employee_service.dto.EmployeeRequestDTO;
import kh.virakchantrak.employee_service.dto.EmployeeResponseDTO;
import kh.virakchantrak.employee_service.entity.EmployeeEntity;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {

    EmployeeEntity toEntity(EmployeeRequestDTO requestDTO);

    EmployeeResponseDTO toResponseDTO(EmployeeEntity entity);
}
