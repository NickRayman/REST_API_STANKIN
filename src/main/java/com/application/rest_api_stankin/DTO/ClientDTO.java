package com.application.rest_api_stankin.DTO;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * DTO для клиента
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientDTO {
    Long clientId;
    String name;
    String email;
    String phone;
}
