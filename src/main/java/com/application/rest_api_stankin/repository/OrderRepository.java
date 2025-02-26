package com.application.rest_api_stankin.repository;

import com.application.rest_api_stankin.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерефейс для интеграции и работы с БД auto_service.orders
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
