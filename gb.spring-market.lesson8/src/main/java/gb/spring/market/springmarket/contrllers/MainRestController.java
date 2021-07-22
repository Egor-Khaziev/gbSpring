package gb.spring.market.springmarket.contrllers;

import gb.spring.market.springmarket.model.Product;
import gb.spring.market.springmarket.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainRestController {

    private final ProductService productService;

    @GetMapping("/info/{id}")
    public Product productInfoPage(@PathVariable long id){
        return productService.getProductByID(id);
    }

    @GetMapping("/products")
    public List<Product> allProductPage(){
        return productService.getProductList();
    }

    @GetMapping("/delete/{id}")
    public void deleteProduct(@PathVariable long id){
        productService.deleteById(id);
    }

    @PostMapping("/new_product")
    public String saveNewProduct(@RequestParam(name = "title") String title, @RequestParam(name = "cost") int cost){
        productService.createNewProduct(title, cost);
        return "it's ok :)";
    }

    @GetMapping("/products_page")
    public Page<Product> productPage(@RequestParam(name = "p") int p){
        return productService.findPage(p-1,10);
    }
}
