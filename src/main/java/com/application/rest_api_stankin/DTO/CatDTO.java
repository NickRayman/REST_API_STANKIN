package com.application.rest_api_stankin.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * DTO сущность в виде котика
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CatDTO {
    String name;
    int age;
    int weight;
}
