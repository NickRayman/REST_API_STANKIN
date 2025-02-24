package com.application.rest_api_stankin.repository;

import com.application.rest_api_stankin.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерефейс для интеграции и работы с БД CatRepo
 */
@Repository
public interface CatRepo extends JpaRepository<Cat, Integer> {

}
