package com.application.rest_api_stankin.controller;

import com.application.rest_api_stankin.DTO.CatDTO;
import com.application.rest_api_stankin.entity.Cat;
import com.application.rest_api_stankin.repository.CatRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс rest-точек для взаимодействия с сервисами StankinService
 */
@Tag(name = "Cats API", description = "Методы для работы с котами")
@Slf4j
@RestController
@RequiredArgsConstructor
public class ControllerRest {

    private final CatRepo catRepo;

    /**
     * Endpoint для добавления JSON-записей в таблицу cats
     *
     * @param catDTO
     */
    @Operation(
            summary = "Endpoint для добавления JSON-записей в таблицу cats",
            description = "Получает DTO кота и билдером собирет и сохраняет сущность в базу"
    )
    @PostMapping("/api/add")
    public void addCat(@RequestBody CatDTO catDTO) {

        log.info(
                "New row: {}", catRepo.save(
                        Cat.builder()
                                .age(catDTO.getAge())
                                .weight(catDTO.getWeight())
                                .name(catDTO.getName())
                                .build())
        );
    }

    /**
     * Endpoint для возврата всех полей таблицы cats
     *
     * @return
     */
    @Operation(
            summary = "Endpoint для возврата всех полей таблицы cats",
            description = "Возвращает список всех котов из базы"
    )
    @GetMapping("/api/all")
    public List<Cat> getAll() {
        return catRepo.findAll();
    }

    /**
     * Endpoint для возврата одной записи по id из таблицы cats
     *
     * @param id
     * @return
     */
    @Operation(
            summary = "Endpoint для возврата одной записи по id из таблицы cats",
            description = "Возвращает кота по id из базы"
    )
    @GetMapping("/api")
    public Cat getCat(@RequestParam int id) {
        return catRepo.findById(id).orElseThrow();
    }

    /**
     * Endpoint для удаления одной записи по id из таблицы cats
     *
     * @param id
     */
    @Operation(
            summary = "Endpoint для удаления одной записи по id из таблицы cats",
            description = "Удаляет запись по id из базы"
    )
    @DeleteMapping("/api")
    public void deleteCat(@RequestParam int id) {
        catRepo.deleteById(id);
    }

    /**
     * Endpoint для редактирования добавленых JSON-записей в таблицу cats
     *
     * @param cat
     */
    @Operation(
            summary = "Endpoint для редактирования добавленых JSON-записей в таблицу cats",
            description = "Изменяет запись по id в базы"
    )
    @PutMapping("/api/add")
    public String changeCat(@RequestBody Cat cat) {
        if (!catRepo.existsById(cat.getId()))
            return "No such row";
        return catRepo.save(cat).toString();
    }

}
