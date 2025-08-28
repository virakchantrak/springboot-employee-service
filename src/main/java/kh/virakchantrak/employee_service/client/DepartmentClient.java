package kh.virakchantrak.employee_service.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class DepartmentClient {

    private final WebClient.Builder webClientBuilder;

    public DepartmentResponseDTO getDepartmentByCode(String departmentCode) {
        return webClientBuilder.build()
                .get()
                .uri("http://DEPARTMENT-SERVICE/api/departments/code/{departmentCode}", departmentCode)
                .retrieve()
                .bodyToMono(DepartmentResponseDTO.class)
                .block();
    }
}
