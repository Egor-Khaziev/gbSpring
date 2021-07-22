package gb.spring.market.springmarket.contrllers;

import gb.spring.market.springmarket.model.Product;
import gb.spring.market.springmarket.services.CartService;
import gb.spring.market.springmarket.services.ProductService;
import gb.spring.market.springmarket.utils.UtilSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class RestController {


    ProductService productService;
    CartService cartService;

    @Autowired
    public RestController(ProductService productService, CartService cartService, UtilSessionFactory sessionFactory) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @GetMapping("/info/{id}")
    public Product productInfoPage(@PathVariable long id){
        return productService.getProductByID(id);
    }

    @GetMapping("/products")
    public List<Product> allProductPage(@PathVariable long id){
        return productService.getProductList();
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(Model model, @PathVariable long id){
        productService.deleteById(id);
        return "Product was delete";
    }

    @PostMapping("/new_product")
    public String saveNewProduct(@RequestParam(name = "t") String title, @RequestParam(name = "c") int cost){
        productService.createNewProduct(title, cost);
        return "it's ok :)";
    }

}
