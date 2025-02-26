package com.application.rest_api_stankin.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Cущность таблицы гость
 */
@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String first_name;

    @Column(unique = true, nullable = false)
    private String last_name;

    private int age;
}
