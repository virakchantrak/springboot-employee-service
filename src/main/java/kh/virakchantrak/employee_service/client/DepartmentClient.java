package kh.virakchantrak.employee_service.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class DepartmentClient {

    private final WebClient.Builder webClientBuilder;

    @CircuitBreaker(name = "departmentService", fallbackMethod = "fallbackDepartment")
    public DepartmentResponseDTO getDepartmentByCode(String departmentCode) {
        return webClientBuilder.build()
                .get()
                .uri("http://DEPARTMENT-SERVICE/api/departments/code/{departmentCode}", departmentCode)
                .retrieve()
                .bodyToMono(DepartmentResponseDTO.class)
                .block();
    }

    private DepartmentResponseDTO fallbackDepartment(String departmentCode) {
        DepartmentResponseDTO fallback = new DepartmentResponseDTO();
        fallback.setId(null);
        fallback.setName("UNKNOWN");
        fallback.setDescription("Department service unavailable (fallback triggered)");
        fallback.setDepartmentCode(departmentCode);
        return fallback;
    }
}
