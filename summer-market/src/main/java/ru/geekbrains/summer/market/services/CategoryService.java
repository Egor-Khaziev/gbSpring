package ru.geekbrains.summer.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.geekbrains.summer.market.model.Category;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.repositories.CategoryRepository;
import ru.geekbrains.summer.market.repositories.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
