package com.application.rest_api_stankin.controller;

import com.application.rest_api_stankin.entity.Cat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        Cat cat = new Cat("", 1, 1);
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            System.out.println("Error with cat");
        }
        return jsonData;
    }
}
