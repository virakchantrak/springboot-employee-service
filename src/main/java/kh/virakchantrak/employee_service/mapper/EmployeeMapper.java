package kh.virakchantrak.employee_service.mapper;

import kh.virakchantrak.employee_service.client.DepartmentResponseDTO;
import kh.virakchantrak.employee_service.dto.EmployeeRequestDTO;
import kh.virakchantrak.employee_service.dto.EmployeeResponseDTO;
import kh.virakchantrak.employee_service.dto.EmployeeWithDepartmentResponseDTO;
import kh.virakchantrak.employee_service.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EmployeeMapper {

    EmployeeEntity toEntity(EmployeeRequestDTO requestDTO);

    EmployeeResponseDTO toResponseDTO(EmployeeEntity entity);

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "name", source = "entity.name")
    @Mapping(target = "position", source = "entity.position")
    @Mapping(target = "department", source = "responseDTO")
    EmployeeWithDepartmentResponseDTO toResponseDTO(EmployeeEntity entity, DepartmentResponseDTO responseDTO);
}
