package gb.spring.market.springmarket.contrllers;

import gb.spring.market.springmarket.dto.CategoryDTO;
import gb.spring.market.springmarket.model.Category;
import gb.spring.market.springmarket.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAllCategory(){
        return categoryService.getCategoryList();
    }

    @PostMapping("/new_category")
    public CategoryDTO saveNewProduct(@RequestParam(name = "title") String title){
        Category newCategory = new Category();
        newCategory.setTitle(title);
        return categoryService.createNewCategory(newCategory);
    }

}
