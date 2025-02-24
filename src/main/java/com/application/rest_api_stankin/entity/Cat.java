package com.application.rest_api_stankin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO сущность в виде котика
 */
@Entity
@Table(name = "cats")
@Getter
@Setter
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int age;

    private int weight;

    public Cat(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Cat() {
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
