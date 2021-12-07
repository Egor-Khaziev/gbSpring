package ru.geekbrains.summer.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SummerMarketApplication {
	// Домашнее задание:
	// 1. Релизовать получение категории по id по REST API (исправить кольцевую ссылку через CategoryDto)
	// 2. * Переделайте POST /products под вариант с Dto

	public static void main(String[] args) {
		SpringApplication.run(SummerMarketApplication.class, args);
	}
}
