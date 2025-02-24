package com.application.rest_api_stankin.controller;

import com.application.rest_api_stankin.entity.Cat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
  Класс rest-точек для взаимодействия с сервисами StankinService
 */
@RestController
public class ControllerRest {

    @Autowired
    private ObjectMapper objectMapper;

    /**
      Метод для проверки контроллера, возврат сообщения по rest-точке "/api/main"
      @return
     */
    @GetMapping("/api/main")
    public String mainListener() {
        return "Hello World";
    }

    @GetMapping("/api/cat")
    public String giveCat() {
        Cat cat = new Cat("Barsik", 5, 10);
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            System.out.println("Error with cat");
        }
        return jsonData;
    }
    @PostMapping("/api/special")
    public String giveSpecialCat(@RequestParam String name) {
        Cat cat = new Cat(name, 5, 10);
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            System.out.println("Error with cat");
        }
        return jsonData;
    }
}
