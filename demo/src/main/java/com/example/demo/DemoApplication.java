package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    // Создать новый спринг проект и самим написать (конфиг можно скопировать) -- done X 2

    // Домашнее задание:
    // 1. Заменить безопасность по ролям на безопасность по правам доступа -- done
    // 2. * Сделать как роли, так и права доступа, у каждой роли свой набор прав -- partly

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
