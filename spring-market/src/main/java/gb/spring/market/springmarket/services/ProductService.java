package gb.spring.market.springmarket.services;

import gb.spring.market.springmarket.model.Product;
import gb.spring.market.springmarket.repository.ProductRepository;
import gb.spring.market.springmarket.utils.NotFoundProductException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductList(){
        return productRepository.getList();
    }

    public void createNewProduct(String title, int cost){
        productRepository.createNewProduct(title,cost);
    }

    public Product getProductByID(long filterID){
       return productRepository.getProductByID(filterID);
    }

}
