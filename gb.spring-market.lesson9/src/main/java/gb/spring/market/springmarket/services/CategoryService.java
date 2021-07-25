package gb.spring.market.springmarket.services;


import gb.spring.market.springmarket.model.Category;
import gb.spring.market.springmarket.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategoryList(){
        return categoryRepository.findAll();
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