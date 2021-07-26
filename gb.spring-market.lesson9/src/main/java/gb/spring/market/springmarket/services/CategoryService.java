package gb.spring.market.springmarket.services;


import gb.spring.market.springmarket.dto.CategoryDTO;
import gb.spring.market.springmarket.dto.ProductDTO;
import gb.spring.market.springmarket.model.Category;
import gb.spring.market.springmarket.model.Product;
import gb.spring.market.springmarket.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryDTO> getCategoryList(){

        List<Category> listEntity = categoryRepository.findAll();
        List<CategoryDTO> listDTO = new ArrayList<>().listEntity

//        return (List<CategoryDTO>) categoryRepository.findAll().stream().map(new Function<Category, CategoryDTO>() {
//
//            @Override
//            public CategoryDTO apply(Category entity) {
//                CategoryDTO dto = new CategoryDTO(entity);
//                return dto;
//            }});

    }

    public Category createNewCategory(Category newCategory){
        return categoryRepository.save(newCategory);
    }

    public Category getCategoryByID(Long id){
        return categoryRepository.findById(id).get();
    }

    public void deleteById(long id){
        categoryRepository.deleteById(id);
    }


}