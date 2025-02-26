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
 * Контроллер для работы с клиентами (с использованием DTO)
 */
@Tag(name = "Clients API", description = "Методы для управления клиентами")
@Slf4j
@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientRepository clientRepository;

    @Operation(summary = "Добавить нового клиента", description = "Создает нового клиента в базе")
    @PostMapping("/add")
    public Client addClient(@RequestBody ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        client.setPhone(clientDTO.getPhone());

        log.info("Добавлен клиент: {}", client);
        return clientRepository.save(client);
    }

    @Operation(summary = "Получить список всех клиентов", description = "Возвращает список всех клиентов")
    @GetMapping("/all")
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream().map(client -> {
            ClientDTO dto = new ClientDTO();
            dto.setClientId(client.getId());
            dto.setName(client.getName());
            dto.setEmail(client.getEmail());
            dto.setPhone(client.getPhone());
            return dto;
        }).collect(Collectors.toList());
    }

    @Operation(summary = "Получить клиента по ID", description = "Возвращает клиента по введенному id")
    @GetMapping("/{id}")
    public Client getPartById(@PathVariable Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Operation(summary = "Обновить клиента по ID", description = "Обновляет клиента по введенному id")
    @PutMapping("/set")
    public Client updateOrder(@RequestBody ClientDTO clientDetails) {
        Client client = clientRepository.findById(clientDetails.getClientId()).orElseThrow();
        client.setEmail(clientDetails.getEmail());
        client.setName(clientDetails.getName());
        client.setPhone(clientDetails.getPhone());
        return clientRepository.save(client);
    }

}
