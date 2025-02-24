package com.application.rest_api_stankin.controller;

import com.application.rest_api_stankin.entity.Cat;
import com.application.rest_api_stankin.repository.CatRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
  Класс rest-точек для взаимодействия с сервисами StankinService
 */
@Slf4j
@RestController
public class ControllerRest {

    private final CatRepo catRepo;
    private final ObjectMapper objectMapper;

    public ControllerRest(CatRepo catRepo, ObjectMapper objectMapper) {
        this.catRepo = catRepo;
        this.objectMapper = objectMapper;
    }

    /**
     * Endpoint для добавления JSON-записей в таблицу cats
     * @param cat
     */
    @PostMapping("/api/add")
    public void addCat(@RequestBody Cat cat) {
        log.info("New row: {}", catRepo.save(cat));
    }

    /**
     * Endpoint для возврата всех полей таблицы cats
     * @return
     */
    @GetMapping("/api/all")
    public List<Cat> getAll() {
            return catRepo.findAll();
    }

    /**
     * Endpoint для возврата одной записи по id из таблицы cats
     * @param id
     * @return
     */
    @GetMapping("/api")
    public Cat getCat(@RequestParam int id) {
        return catRepo.findById(id).orElseThrow();
    }

    /**
     * Endpoint для удаления одной записи по id из таблицы cats
     * @param id
     */
    @DeleteMapping("/api")
    public void deleteCat(@RequestParam int id) {
        catRepo.deleteById(id);
    }

    /**
     * Endpoint для добавления JSON-записей в таблицу cats
     * @param cat
     */
    @PutMapping("/api/add")
    public String changeCat(@RequestBody Cat cat) {
        if (!catRepo.existsById(cat.getId()))
            return "No such row";
        return catRepo.save(cat).toString();
    }

 }
