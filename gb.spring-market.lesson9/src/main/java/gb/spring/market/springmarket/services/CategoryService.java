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
        List<CategoryDTO> listDTO = new ArrayList<>();

        for (Category category: listEntity) {
            listDTO.add(new CategoryDTO(category));
        }

        return listDTO;
    }

    public CategoryDTO createNewCategory(Category newCategory){
        return new CategoryDTO(categoryRepository.save(newCategory));
    }

    public CategoryDTO getCategoryDTOByID(Long id){
        return  new CategoryDTO(categoryRepository.findById(id).get());
    }

    public Category getCategoryByID(Long id){
        return categoryRepository.findById(id).get();
    }

    public Category getCategoryByTitle(String title){
        return categoryRepository.findCategoryByTitleEquals(title);
    }

    public void deleteById(long id){
        categoryRepository.deleteById(id);
    }

}