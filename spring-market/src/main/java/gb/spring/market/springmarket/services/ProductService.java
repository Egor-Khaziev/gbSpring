package gb.spring.market.springmarket.services;

import gb.spring.market.springmarket.model.Product;
import gb.spring.market.springmarket.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProductList(){
        //return productRepository.getList();
        return productRepository.findAll();
    }

    public void createNewProduct(String title, int cost){
        //productRepository.createNewProduct(title,cost);
        productRepository.save(new Product(title,cost));
    }

    public Product getProductByID(long id){
        //return  productRepository.getProductByID(id);
        return productRepository.findById(id).get();
    }

    public void deleteById(long id){
        productRepository.deleteById(id);
    }

}
