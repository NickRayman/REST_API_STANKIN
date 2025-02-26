package com.application.rest_api_stankin.repository;

import com.application.rest_api_stankin.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерефейс для интеграции и работы с БД auto_service.parts
 */
@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
}
