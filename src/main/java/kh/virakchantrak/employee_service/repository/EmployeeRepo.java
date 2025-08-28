package kh.virakchantrak.employee_service.repository;

import kh.virakchantrak.employee_service.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {
    boolean existsByEmail(String email);
}
