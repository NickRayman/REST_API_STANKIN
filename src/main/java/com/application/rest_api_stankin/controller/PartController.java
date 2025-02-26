package com.application.rest_api_stankin.controller;

import com.application.rest_api_stankin.DTO.MenuDTO;
import com.application.rest_api_stankin.entity.Menu;
import com.application.rest_api_stankin.repository.MenuRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер для блюд (с использованием DTO)
 */
@Tag(name = "Parts API", description = "Методы для работы с меню")
@Slf4j
@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor
public class PartController {

    private final MenuRepository menuRepository;

    @Operation(summary = "Добавить новое блюдо", description = "Сохраняет новое блюдо в базе")
    @PostMapping("/add")
    public Menu addPart(@RequestBody MenuDTO menuDTO) {
        Menu menu = new Menu();
        menu.setName(menuDTO.getName());
        menu.setDescription(menuDTO.getDescription());
        menu.setPrice(menuDTO.getPrice());

        log.info("Добавлено блюдо: {}", menu);
        return menuRepository.save(menu);
    }

    @Operation(summary = "Получить список всех блюд", description = "Возвращает список всех блюд")
    @GetMapping("/all")
    public List<MenuDTO> getAllParts() {
        return menuRepository.findAll().stream().map(menu -> {
            MenuDTO dto = new MenuDTO();
            dto.setMenuId(menu.getId());
            dto.setName(menu.getName());
            dto.setDescription(menu.getDescription());
            dto.setPrice(menu.getPrice());
            return dto;
        }).collect(Collectors.toList());
    }

    @Operation(summary = "Получить блюдо по ID", description = "Возвращает блюдо по введенному id")
    @GetMapping("/{id}")
    public Menu getPartById(@PathVariable Long id) {
        return menuRepository.findById(id).orElseThrow();
    }

    @Operation(summary = "Обновить блюдо по ID", description = "Обновляет блюдо по введенному id")
    @PutMapping("/set")
    public Menu updateOrder(@RequestBody MenuDTO partDetails) {
        Menu menu = menuRepository.findById(partDetails.getMenuId()).orElseThrow();
        menu.setName(partDetails.getName());
        menu.setPrice(partDetails.getPrice());
        menu.setDescription(partDetails.getDescription());
        return menuRepository.save(menu);
    }
}
