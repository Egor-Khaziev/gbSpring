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
    public ProductDTO saveNewProduct(@RequestBody ProductDTO newProductDTO){
        Product newProduct = new Product();
        newProduct.setTitle(newProductDTO.getTitle());
        newProduct.setPrice(newProductDTO.getPrice());
        newProduct.setCategory(categoryService.getCategoryByTitle(newProductDTO.getCategory()));

        return productService.createNewProduct(newProduct);
    }

    @GetMapping
    public Page<ProductDTO> productPage(@RequestParam(name = "p") int p){
        return productService.findPage(p-1,10);
    }
}
