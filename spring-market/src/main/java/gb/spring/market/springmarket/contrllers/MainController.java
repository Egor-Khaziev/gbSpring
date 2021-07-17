package gb.spring.market.springmarket.contrllers;

import gb.spring.market.springmarket.repository.ProductRepository;
import gb.spring.market.springmarket.services.CartService;
import gb.spring.market.springmarket.services.ProductService;
import gb.spring.market.springmarket.utils.UtilSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    ProductService productService;
    CartService cartService;

    @Autowired
    public MainController(ProductService productService, CartService cartService, UtilSessionFactory sessionFactory) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @GetMapping("/new_product")
    public String newProduct(Model model){
        return "create_product";
    }

    @PostMapping("/new_product")
    public String saveNewProduct(@RequestParam String title, @RequestParam int cost){
        productService.createNewProduct(title, cost);
        return "redirect:/";
    }

    @GetMapping("/info/{id}")
    public String productInfoPage(Model model, @PathVariable long id){
        model.addAttribute("product", productService.getProductByID(id));
        return "productinfo";
    }

//    @PostMapping("/new_product")
//    public String saveNewProduct(@RequestParam String title, @RequestParam int cost){
//        productService.createNewProduct(title, cost);
//        return "redirect:/";
//    }

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("items", productService.getProductList());
        model.addAttribute("cartService", cartService);
        return "index";
    }
}
