package com.application.rest_api_stankin.DTO;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * DTO для заказов
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDTO {
    Long orderId;
    Long clientId;
    Long partId;
    String status;
}
