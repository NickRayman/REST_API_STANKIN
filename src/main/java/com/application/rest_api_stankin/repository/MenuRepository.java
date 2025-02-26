package com.application.rest_api_stankin.repository;

import com.application.rest_api_stankin.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерефейс для интеграции и работы с БД restaurant.menu
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
