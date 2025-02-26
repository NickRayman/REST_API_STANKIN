package com.application.rest_api_stankin.DTO;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * DTO для гостя
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientDTO {
    Long clientId;
    String first_name;
    String last_name;
    int age;
}
