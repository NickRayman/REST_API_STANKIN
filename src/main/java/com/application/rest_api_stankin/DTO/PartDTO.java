package com.application.rest_api_stankin.DTO;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * DTO для деталей
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PartDTO {
    Long partId;
    String name;
    double price;
}
