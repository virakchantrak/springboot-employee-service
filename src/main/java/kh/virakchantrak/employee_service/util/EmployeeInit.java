package kh.virakchantrak.employee_service.util;

import jakarta.annotation.PostConstruct;
import kh.virakchantrak.employee_service.entity.EmployeeEntity;
import kh.virakchantrak.employee_service.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeInit {
    private final EmployeeRepo employeeRepo;

    @PostConstruct
    public void init() {
        this.create();
    }

    public void create() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName("Virak");
        employeeEntity.setEmail("virak@gmail.com");
        employeeRepo.save(employeeEntity);

        employeeEntity = new EmployeeEntity();
        employeeEntity.setName("Sokha");
        employeeEntity.setEmail("sokha@gmail.com");
        employeeRepo.save(employeeEntity);

        employeeEntity = new EmployeeEntity();
        employeeEntity.setName("Sreymom");
        employeeEntity.setEmail("sreymom@gmail.com");
        employeeRepo.save(employeeEntity);
    }
}
