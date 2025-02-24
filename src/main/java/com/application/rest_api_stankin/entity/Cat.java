package com.application.rest_api_stankin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
  DTO сущность в виде котика
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cat {
    private String name;
    private int age;
    private int weight;
}
