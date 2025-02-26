package com.application.rest_api_stankin.DTO;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

/**
 * DTO для блюд
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuDTO {
    Long menuId;
    String name;
    String description;
    BigDecimal price;
}
