package kh.virakchantrak.employee_service.repository;

import kh.virakchantrak.employee_service.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {
    Optional<EmployeeEntity> findByName(String name);
    boolean existsByEmail(String email);
}
