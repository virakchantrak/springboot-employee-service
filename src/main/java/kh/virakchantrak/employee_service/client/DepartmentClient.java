package kh.virakchantrak.employee_service.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class DepartmentClient {

    private final WebClient.Builder webClientBuilder;

    public DepartmentResponseDTO getDepartmentById(Long id) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8080/api/departments/{id}", id)
                .retrieve()
                .bodyToMono(DepartmentResponseDTO.class)
                .block();
    }
}
