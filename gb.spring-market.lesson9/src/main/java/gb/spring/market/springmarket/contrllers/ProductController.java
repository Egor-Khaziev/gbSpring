package gb.spring.market.springmarket.contrllers;

import gb.spring.market.springmarket.dto.ProductDTO;
import gb.spring.market.springmarket.model.Product;
import gb.spring.market.springmarket.services.CategoryService;
import gb.spring.market.springmarket.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public ProductDTO productInfoPage(@PathVariable long id){
        return productService.getProductByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id){
        productService.deleteById(id);
    }

    @PostMapping("/new_product")
    public ProductDTO saveNewProduct(@RequestParam(name = "title") String title, @RequestParam(name = "price") int price, @RequestParam(name = "category") long category){
        Product newProduct = new Product();
        newProduct.setTitle(title);
        newProduct.setPrice(price);
        newProduct.setCategory(categoryService.getCategoryByID(category));

        return productService.createNewProduct(newProduct);
    }

    @GetMapping
    public Page<ProductDTO> productPage(@RequestParam(name = "p") int p){
        return productService.findPage(p-1,10);
    }
}
