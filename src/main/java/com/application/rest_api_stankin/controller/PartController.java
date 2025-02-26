package com.application.rest_api_stankin.controller;

import com.application.rest_api_stankin.DTO.PartDTO;
import com.application.rest_api_stankin.entity.Part;
import com.application.rest_api_stankin.repository.PartRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер для деталей (с использованием DTO)
 */
@Tag(name = "Parts API", description = "Методы для работы с деталями")
@Slf4j
@RestController
@RequestMapping("/api/parts")
@RequiredArgsConstructor
public class PartController {

    private final PartRepository partRepository;

    @Operation(summary = "Добавить новую деталь", description = "Сохраняет новую деталь в базе")
    @PostMapping("/add")
    public Part addPart(@RequestBody PartDTO partDTO) {
        Part part = new Part();
        part.setPartName(partDTO.getName());
        part.setPrice(partDTO.getPrice());

        log.info("Добавлена деталь: {}", part);
        return partRepository.save(part);
    }

    @Operation(summary = "Получить список всех деталей", description = "Возвращает список всех деталей")
    @GetMapping("/all")
    public List<PartDTO> getAllParts() {
        return partRepository.findAll().stream().map(part -> {
            PartDTO dto = new PartDTO();
            dto.setPartId(part.getId());
            dto.setName(part.getPartName());
            dto.setPrice(part.getPrice());
            return dto;
        }).collect(Collectors.toList());
    }

    @Operation(summary = "Получить деталь по ID", description = "Возвращает деталь по введенному id")
    @GetMapping("/{id}")
    public Part getPartById(@PathVariable Long id) {
        return partRepository.findById(id).orElseThrow();
    }

    @Operation(summary = "Обновить деталь по ID", description = "Обновляет деталь по введенному id")
    @PutMapping("/set")
    public Part updateOrder(@RequestBody PartDTO partDetails) {
        Part part = partRepository.findById(partDetails.getPartId()).orElseThrow();
        part.setPartName(partDetails.getName());
        part.setPrice(partDetails.getPrice());
        return partRepository.save(part);
    }
}
