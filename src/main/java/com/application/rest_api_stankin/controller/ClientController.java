package com.application.rest_api_stankin.controller;

import com.application.rest_api_stankin.DTO.ClientDTO;
import com.application.rest_api_stankin.entity.Client;
import com.application.rest_api_stankin.repository.ClientRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер для работы с гостями (с использованием DTO)
 */
@Tag(name = "Clients API", description = "Методы для управления гостями")
@Slf4j
@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientRepository clientRepository;

    @Operation(summary = "Добавить нового гостя", description = "Создает нового гостя в базе")
    @PostMapping("/add")
    public Client addClient(@RequestBody ClientDTO clientDTO) {
        Client client = new Client();
        client.setFirst_name(clientDTO.getFirst_name());
        client.setLast_name(clientDTO.getLast_name());
        client.setAge(clientDTO.getAge());

        log.info("Добавлен гость: {}", client);
        return clientRepository.save(client);
    }

    @Operation(summary = "Получить список всех клиентов", description = "Возвращает список всех клиентов")
    @GetMapping("/all")
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream().map(client -> {
            ClientDTO dto = new ClientDTO();
            dto.setClientId(client.getId());
            dto.setFirst_name(client.getFirst_name());
            dto.setLast_name(client.getLast_name());
            dto.setAge(client.getAge());
            return dto;
        }).collect(Collectors.toList());
    }

    @Operation(summary = "Получить гостя по ID", description = "Возвращает гостя по введенному id")
    @GetMapping("/{id}")
    public Client getPartById(@PathVariable Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Operation(summary = "Обновить гостя по ID", description = "Обновляет гостя по введенному id")
    @PutMapping("/set")
    public Client updateOrder(@RequestBody ClientDTO clientDetails) {
        Client client = clientRepository.findById(clientDetails.getClientId()).orElseThrow();
        client.setFirst_name(clientDetails.getFirst_name());
        client.setLast_name(clientDetails.getLast_name());
        client.setAge(clientDetails.getAge());
        return clientRepository.save(client);
    }

}
